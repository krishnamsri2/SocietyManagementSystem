package com.example.ProjectLatest.service;


import com.example.ProjectLatest.entity.*;

import com.example.ProjectLatest.repository.ComplaintHistoryRepository;
import com.example.ProjectLatest.repository.ComplaintRepository;
import com.example.ProjectLatest.repository.FlatRepository;
import com.example.ProjectLatest.repository.UserDetailRepository;
import com.example.ProjectLatest.response.ComplaintHistoryResponse;
import com.example.ProjectLatest.response.ComplaintResponse;
import com.example.ProjectLatest.response.ComplaintWorkerResponse;
import com.example.ProjectLatest.to.ComplaintTO;
import com.example.ProjectLatest.to.WorkTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private ComplaintHistoryRepository complaintHistoryRepository;
    @Autowired
    private FlatRepository flatRepository;
    @Autowired
    private UserDetailRepository userDetailRepository;


    //POST
    public void saveComplaint(ComplaintTO complaintTO){

        try{
            long flatId = complaintTO.getFlatId();
            long userId = complaintTO.getUserId();
            Flat flat = flatRepository.getById(flatId);


            Complaint complaint = new Complaint(complaintTO.getType(), ComplaintStatus.CREATED, complaintTO.getComplaintDetails(), flat.getFlatNo(),userId);


            complaint.setFlat(flat);



            ComplaintHistory complaintHistory = new ComplaintHistory(complaint.getType(), ComplaintStatus.CREATED, flat.getFlatNo(), complaint);
            complaint.getComplaintHistories().add(complaintHistory);

            complaintHistoryRepository.save(complaintHistory);
        }
        catch(Exception e)
        {

            e.printStackTrace();
        }

        return;

    }

    public List<ComplaintWorkerResponse> getCompletedWorks(long workerId)
    {
        List<ComplaintWorkerResponse> complaintWorkerResponses = new ArrayList<ComplaintWorkerResponse>();

        List<Complaint> complaints = complaintRepository.findByWorkerIdAndStatus(workerId);

        for (Complaint complaint : complaints) {
            String flatNo = complaint.getFlat().getFlatNo();
            String towerName = complaint.getFlat().getTow2().getTowerName();
            ComplaintWorkerResponse complaintWorkerResponse = new ComplaintWorkerResponse(complaint.getComplaintDetails(), complaint.getComplaintId(),complaint.getComplaintStatus(), complaint.getType(), flatNo, towerName);
            complaintWorkerResponses.add(complaintWorkerResponse);
        }

        return complaintWorkerResponses;

    }

    //GET Available complaints for Workers
    public List<ComplaintWorkerResponse> getComplaintsForWorkers()
    {
        List<ComplaintWorkerResponse> complaintWorkerResponses = new ArrayList<ComplaintWorkerResponse>();
        try {
            List<Complaint> complaints = complaintRepository.findByComplaintStatus(ComplaintStatus.CREATED);
            for (Complaint complaint : complaints) {
                String flatNo = complaint.getFlat().getFlatNo();
                String towerName = complaint.getFlat().getTow2().getTowerName();
                ComplaintWorkerResponse complaintWorkerResponse = new ComplaintWorkerResponse(complaint.getComplaintDetails(), complaint.getComplaintId(),complaint.getComplaintStatus(), complaint.getType(), flatNo, towerName);
                complaintWorkerResponses.add(complaintWorkerResponse);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return complaintWorkerResponses;
    }

    public void assignAndUpdateWork(WorkTO workTO)
    {
        try {
            Complaint complaint = complaintRepository.getById(workTO.getComplaintId());


            long workerId = workTO.getWorkerId();
            long userId = workTO.getUserId();
            ComplaintStatus complaintStatus = workTO.getComplaintStatus();

            if (complaintStatus.equals(ComplaintStatus.DECLINED)) {
                complaint.setWorkerId(0L);// userId = 0 represents the work is assigned to no one.
                complaint.setStatus(ComplaintStatus.CREATED);
            }
            else if(complaintStatus.equals(ComplaintStatus.CLOSED))
            {   System.out.println("This is userId "+userId);
                complaint.setUserId(userId);
                complaint.setStatus(workTO.getComplaintStatus());
            }
            else
            {
                complaint.setWorkerId(workerId);

                complaint.setStatus(workTO.getComplaintStatus());
            }
            complaintRepository.save(complaint);
            ComplaintHistory complaintHistory = new ComplaintHistory(complaint.getType(), workTO.getComplaintStatus(), complaint.getCreatedBy(), complaint);

            if (!complaintStatus.equals(ComplaintStatus.CLOSED)){
                complaintHistory.setUserId(workerId);}
            else if(complaintStatus.equals(ComplaintStatus.CLOSED)){
                complaintHistory.setUserId(userId);
            }
            System.out.println("This is userId "+complaint.getUserId());

            complaint.getComplaintHistories().add(complaintHistory);
            System.out.println("This is userId "+complaintHistory.getComplaint().getUserId());
            complaintHistoryRepository.save(complaintHistory);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return;
    }

    public List<ComplaintWorkerResponse> assignedWorks(long workerId)
    {
        List<ComplaintWorkerResponse> complaintWorkerResponses = new ArrayList<ComplaintWorkerResponse>();

        try {
            List<Complaint> complaints = complaintRepository.findByWorkerIdAndAssignedStatus(workerId);
            for (Complaint complaint : complaints) {
                ComplaintWorkerResponse complaintWorkerResponse = new ComplaintWorkerResponse(complaint.getComplaintDetails(), complaint.getComplaintId(),complaint.getComplaintStatus(), complaint.getType(), complaint.getFlat().getFlatNo(), complaint.getFlat().getTow2().getTowerName());
                complaintWorkerResponses.add(complaintWorkerResponse);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return complaintWorkerResponses;
    }

    public List<ComplaintResponse> allComplaints(long flatId)
    {
        List<ComplaintResponse> complaintResponses = new ArrayList<ComplaintResponse>();;

        try {
            List<Complaint> complaints = complaintRepository.findByFlatId(flatId);
            for (Complaint complaint : complaints) {
                ComplaintResponse complaintResponse = new ComplaintResponse(complaint.getComplaintId(), complaint.getType(), complaint.getComplaintStatus());
                complaintResponses.add(complaintResponse);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return complaintResponses;
    }


    public List<ComplaintHistoryResponse> allComplaintHistory(long complaintId)
    {
        List<ComplaintHistoryResponse> complaintHistoryResponses = new ArrayList<ComplaintHistoryResponse>();
        try {
            List<ComplaintHistory> complaintHistories = complaintHistoryRepository.findByComplaintId(complaintId    );

            for (ComplaintHistory complaintHistory : complaintHistories)
            {
                System.out.println("complaint history id: "+complaintHistory.getCmpHisId());
                ComplaintHistoryResponse complaintHistoryResponse = new ComplaintHistoryResponse(complaintHistory.getStatus(), complaintHistory.getCreated());
                if (complaintHistory.getStatus() != ComplaintStatus.CREATED)
                {
                    Long userId = complaintHistory.getUserId();
                    System.out.println("This complaint History Id:"+userId);
                    if(userId!=0 && userId!=null){
                        UserDetails userDetails = userDetailRepository.getById(userId);
                    String workerName = userDetails.getFirstName() + " " + userDetails.getLastName();
                    long workerMobileNo = userDetails.getPhoneNumber();
                    complaintHistoryResponse.setWorkerAssigned(workerName);
                    complaintHistoryResponse.setWorkerMobileNo(workerMobileNo);}
                }
                complaintHistoryResponses.add(complaintHistoryResponse);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return complaintHistoryResponses;
    }

}
