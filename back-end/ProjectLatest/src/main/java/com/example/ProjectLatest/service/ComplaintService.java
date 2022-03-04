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
            Flat flat = flatRepository.getById(flatId);

            Complaint complaint = new Complaint(complaintTO.getType(), ComplaintStatus.CREATED, complaintTO.getComplaintDetails(), flat.getFlatNo());
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

    //GET Available complaints for Workers
    public List<ComplaintWorkerResponse> getComplaintsForWorkers()
    {
        List<ComplaintWorkerResponse> complaintWorkerResponses = new ArrayList<ComplaintWorkerResponse>();
        try {
            List<Complaint> complaints = complaintRepository.findByComplaintStatus(ComplaintStatus.CREATED);
            for (Complaint complaint : complaints) {
                String flatNo = complaint.getFlat().getFlatNo();
                String towerName = complaint.getFlat().getTow2().getTowerName();
                ComplaintWorkerResponse complaintWorkerResponse = new ComplaintWorkerResponse(complaint.getComplaintDetails(), complaint.getComplaintId(), complaint.getType(), flatNo, towerName);
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

            long workerId = workTO.getUserId();
            ComplaintStatus complaintStatus = workTO.getComplaintStatus();

            // A worker can decline only if complaint status is assigned not after completion or after complaint is closed
            if (complaintStatus.equals(ComplaintStatus.DECLINED) && (complaint.getComplaintStatus() != ComplaintStatus.COMPLETED || complaint.getComplaintStatus() != ComplaintStatus.CLOSED)) {
                complaint.setUserId(null);
                complaint.setStatus(ComplaintStatus.CREATED);
            } else {
                complaint.setUserId(workerId);
                complaint.setStatus(workTO.getComplaintStatus());
            }

            ComplaintHistory complaintHistory = new ComplaintHistory(complaint.getType(), workTO.getComplaintStatus(), complaint.getCreatedBy(), complaint);
            complaintHistory.setUserId(workerId);
            complaint.getComplaintHistories().add(complaintHistory);
            complaintHistoryRepository.save(complaintHistory);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return;
    }

    public List<ComplaintWorkerResponse> assignedWorks(long userId)
    {
        List<ComplaintWorkerResponse> complaintWorkerResponses = new ArrayList<ComplaintWorkerResponse>();

        try {
            List<Complaint> complaints = complaintRepository.findByUserId(userId);
            for (Complaint complaint : complaints) {
                ComplaintWorkerResponse complaintWorkerResponse = new ComplaintWorkerResponse(complaint.getComplaintDetails(), complaint.getComplaintId(), complaint.getType(), complaint.getFlat().getFlatNo(), complaint.getFlat().getTow2().getTowerName());
                complaintWorkerResponses.add(complaintWorkerResponse);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return complaintWorkerResponses;
    }

    public List<ComplaintResponse> allComplaints(ComplaintTO complaintTO)
    {
        List<ComplaintResponse> complaintResponses = new ArrayList<ComplaintResponse>();;

        try {
            List<Complaint> complaints = complaintRepository.findByFlatId(complaintTO.getFlatId());
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

    public List<ComplaintHistoryResponse> allComplaintHistory(ComplaintTO complaintTO)
    {
        List<ComplaintHistoryResponse> complaintHistoryResponses = new ArrayList<ComplaintHistoryResponse>();
        try {
            List<ComplaintHistory> complaintHistories = complaintHistoryRepository.findByComplaintId(complaintTO.getComplaintId());
            for (ComplaintHistory complaintHistory : complaintHistories)
            {
                ComplaintHistoryResponse complaintHistoryResponse = new ComplaintHistoryResponse(complaintHistory.getStatus(), complaintHistory.getCreated());
                if (complaintHistory.getStatus() != ComplaintStatus.CREATED)
                {
                    long userId = complaintHistory.getUserId();
                    UserDetails userDetails = userDetailRepository.getById(userId);
                    String workerName = userDetails.getFirstName() + " " + userDetails.getLastName();
                    long workerMobileNo = userDetails.getPhoneNumber();
                    complaintHistoryResponse.setWorkerAssigned(workerName);
                    complaintHistoryResponse.setWorkerMobileNo(workerMobileNo);
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
