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
    public ComplaintResponse saveComplaint(ComplaintTO complaint) {
        ComplaintResponse complaintResponse = null;
        try {
            Complaint tempComplaint = new Complaint(complaint.getType(), 76);
            complaintResponse = new ComplaintResponse(tempComplaint.getType(), tempComplaint.getcomplaintId());
            repository.save(tempComplaint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return complaintResponse;

    }

    //PUT
    public ComplaintResponse updateComplaint(long id,ComplaintTO complaint) {
        ComplaintResponse complaintResponse = null;
        try {
            Complaint existingComplaint = repository.findById(id).orElse(null);

            existingComplaint.setType(complaint.getType());
            complaintResponse = new ComplaintResponse(existingComplaint.getType(), existingComplaint.getcomplaintId());
            repository.save(existingComplaint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return complaintResponse;
    }

    //GET
    public List<ComplaintResponse> getComplaints() {
        List<ComplaintResponse> responseList = null;
        try {
            responseList = new ArrayList<>();
            List<Complaint> complaintList = repository.findAll();
            for (Complaint complaint : complaintList) {
                responseList.add(new ComplaintResponse(complaint.getType(), complaint.getcomplaintId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseList;

    }

    public ComplaintResponse getComplaintById(long id) {
        ComplaintResponse complaintResponse = null;
        try {
            Complaint existingComplaint = repository.findById(id).orElse(null);
            complaintResponse = new ComplaintResponse(existingComplaint.getType(), existingComplaint.getcomplaintId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return complaintResponse;
    }

    //DELETE
    public String deleteComplaint(long id){
        try {
            Complaint complaint = repository.findById(id).orElse(null);
            if (complaint != null) {
                complaint.setIsDeleted(true);

                return "Product removed !!" + id;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return " No Comment found with this !!" +id;
    }


}
