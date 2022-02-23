package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.Complaint;
import com.example.ProjectLatest.repository.ComplaintRepository;
import com.example.ProjectLatest.response.ComplaintResponse;
import com.example.ProjectLatest.to.ComplaintTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplaintService {
    @Autowired
    private ComplaintRepository repository;
    //POST
    public ComplaintResponse saveComplaint(ComplaintTO complaint){

        Complaint tempComplaint = new Complaint(complaint.getType(), 76);
        ComplaintResponse complaintResponse = new ComplaintResponse(tempComplaint.getType(), tempComplaint.getcomplaintId());
        repository.save(tempComplaint);
        return complaintResponse;

    }

    //PUT
    public ComplaintResponse updateComplaint(long id,ComplaintTO complaint){
        Complaint existingComplaint=repository.findById(id).orElse(null);

        existingComplaint.setType(complaint.getType());
        ComplaintResponse complaintResponse = new ComplaintResponse(existingComplaint.getType(), existingComplaint.getcomplaintId());
        repository.save(existingComplaint);
        return complaintResponse;
    }

    //GET
    public List<ComplaintResponse> getComplaints(){
        List<ComplaintResponse> responseList = new ArrayList<>();
        List<Complaint> complaintList =   repository.findAll();
        for(Complaint complaint: complaintList){
            responseList.add(new ComplaintResponse(complaint.getType(), complaint.getcomplaintId()));
        }
        return responseList;

    }

    public ComplaintResponse getComplaintById(long id){
        Complaint existingComplaint = repository.findById(id).orElse(null);
        ComplaintResponse complaintResponse = new ComplaintResponse(existingComplaint.getType(), existingComplaint.getcomplaintId());
        return complaintResponse;
    }

    //DELETE
    public String deleteComplaint(long id){
        Complaint complaint = repository.findById(id).orElse(null);
        if(complaint!=null){
            complaint.setIsDeleted(true);

            return "Product removed !!" +id;
        }
        return " No Comment found with this !!" +id;
    }


}
