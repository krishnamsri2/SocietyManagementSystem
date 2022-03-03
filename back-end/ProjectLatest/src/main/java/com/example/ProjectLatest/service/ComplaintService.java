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

        System.out.println(complaintTO.getComplaintDetails());
        long flatId = complaintTO.getFlatId();
        Flat flat = flatRepository.getById(flatId);

        Complaint complaint = new Complaint(complaintTO.getType(),ComplaintStatus.CREATED,complaintTO.getComplaintDetails(),flat.getFlatNo());
        complaint.setFlat(flat);


        ComplaintHistory complaintHistory = new ComplaintHistory(complaint.getType(), ComplaintStatus.CREATED,flat.getFlatNo(),complaint);
        complaint.getComplaintHistories().add(complaintHistory);
        complaintRepository.save(complaint);
        complaintHistoryRepository.save(complaintHistory);


        return;

    }

    //GET Available complaints for Workers
    public List<ComplaintWorkerResponse> getComplaintsForWorkers()
    {
        List<Complaint> complaints = complaintRepository.findByComplaintStatus(ComplaintStatus.CREATED);
        List<ComplaintWorkerResponse> complaintWorkerResponses = new ArrayList<ComplaintWorkerResponse>();

        for(Complaint complaint:complaints)
        {
            String flatNo = complaint.getFlat().getFlatNo();
            String towerName = complaint.getFlat().getTow2().getTowerName();
            ComplaintWorkerResponse complaintWorkerResponse = new ComplaintWorkerResponse(complaint.getComplaintDetails(),complaint.getComplaintId(),complaint.getType(),flatNo,towerName);
            complaintWorkerResponses.add(complaintWorkerResponse);
        }
        return complaintWorkerResponses;
    }

    public void assignAndUpdateWork(WorkTO workTO)
    {

        Complaint complaint =complaintRepository.getById(workTO.getComplaintId());

        long workerId = workTO.getUserId();
        ComplaintStatus complaintStatus = workTO.getComplaintStatus();

        if(complaintStatus.equals(ComplaintStatus.DECLINED))
        {
            complaint.setUserId(null);
            complaint.setStatus(ComplaintStatus.CREATED);
        }
        else {
            complaint.setUserId(workerId);
            complaint.setStatus(workTO.getComplaintStatus());
        }

        ComplaintHistory complaintHistory = new ComplaintHistory(complaint.getType(), workTO.getComplaintStatus(),complaint.getCreatedBy(),complaint);
        complaintHistory.setUserId(workerId);
        complaint.getComplaintHistories().add(complaintHistory);
        complaintHistoryRepository.save(complaintHistory);
        return;
    }

    public List<ComplaintWorkerResponse> assignedWorks(long userId)
    {
        List<Complaint> complaints = complaintRepository.findByUserId(userId);
        List<ComplaintWorkerResponse> complaintWorkerResponses = new ArrayList<ComplaintWorkerResponse>();

        for(Complaint complaint:complaints) {
            ComplaintWorkerResponse complaintWorkerResponse = new ComplaintWorkerResponse(complaint.getComplaintDetails(), complaint.getComplaintId(), complaint.getType(), complaint.getFlat().getFlatNo(), complaint.getFlat().getTow2().getTowerName());
            complaintWorkerResponses.add(complaintWorkerResponse);
        }
        return complaintWorkerResponses;
    }

    public List<ComplaintResponse> allComplaints(ComplaintTO complaintTO)
    {
        List<Complaint> complaints = complaintRepository.findByFlatId(complaintTO.getFlatId());
        List<ComplaintResponse> complaintResponses = new ArrayList<ComplaintResponse>();

        for(Complaint complaint:complaints)
        {
            ComplaintResponse complaintResponse = new ComplaintResponse(complaint.getComplaintId(),complaint.getType(),complaint.getComplaintStatus());
            complaintResponses.add(complaintResponse);
        }
        return complaintResponses;
    }

    public List<ComplaintHistoryResponse> allComplaintHistory(ComplaintTO complaintTO)
    {
        System.out.print(complaintTO.getComplaintId());
        List<ComplaintHistory> complaintHistories = complaintHistoryRepository.findByComplaintId(complaintTO.getComplaintId());
        List<ComplaintHistoryResponse> complaintHistoryResponses = new ArrayList<ComplaintHistoryResponse>();
        for(ComplaintHistory complaintHistory:complaintHistories)
        {
            ComplaintHistoryResponse complaintHistoryResponse = new ComplaintHistoryResponse(complaintHistory.getStatus(),complaintHistory.getCreated());
            if(complaintHistory.getStatus()!=ComplaintStatus.CREATED)
            {
                long userId= complaintHistory.getUserId();
                UserDetails userDetails = userDetailRepository.getById(userId);
                String workerName = userDetails.getFirstName()+" "+userDetails.getLastName();
                long workerMobileNo = userDetails.getPhoneNumber();
                complaintHistoryResponse.setWorkerAssigned(workerName);
                complaintHistoryResponse.setWorkerMobileNo(workerMobileNo);
            }
            complaintHistoryResponses.add(complaintHistoryResponse);
        }
        return complaintHistoryResponses;
    }

    /*//PUT
    public ComplaintResponse updateComplaint(long id,ComplaintTO complaint){
        Complaint existingComplaint=complaintRepository.findById(id).orElse(null);

        existingComplaint.setType(complaint.getType());
        existingComplaint.setStatus(complaint.getComplaintStatus());
        ComplaintResponse complaintResponse = new ComplaintResponse(existingComplaint.getType(), existingComplaint.getcomplaintId());
        complaintRepository.save(existingComplaint);
        return complaintResponse;
    }

    //GET
    public List<ComplaintResponse> getComplaints(){
        List<ComplaintResponse> responseList = new ArrayList<>();
        List<Complaint> complaintList =   complaintRepository.findAll();
        for(Complaint complaint: complaintList){
            responseList.add(new ComplaintResponse(complaint.getType(), complaint.getcomplaintId()));
        }
        return responseList;

    }

    public ComplaintResponse getComplaintById(long id){
        Complaint existingComplaint = complaintRepository.findById(id).orElse(null);
        ComplaintResponse complaintResponse = new ComplaintResponse(existingComplaint.getType(), existingComplaint.getcomplaintId());
        return complaintResponse;
    }

    //DELETE
    public String deleteComplaint(long id){
        Complaint complaint = complaintRepository.findById(id).orElse(null);
        if(complaint!=null){
            complaint.setIsDeleted(true);

            return "Product removed !!" +id;
        }
        return " No Comment found with this !!" +id;
    }*/


}
