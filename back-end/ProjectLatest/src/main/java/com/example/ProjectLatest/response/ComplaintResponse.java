package com.example.ProjectLatest.response;

import com.example.ProjectLatest.entity.Complaint;
import com.example.ProjectLatest.entity.ComplaintStatus;

import java.util.List;

public class ComplaintResponse {

    private String type;
    private long  complaintId;
    private ComplaintStatus complaintStatus;

    public ComplaintResponse(long complaintId, String type, ComplaintStatus complaintStatus) {
        this.type = type;
        this.complaintId = complaintId;
        this.complaintStatus = complaintStatus;

    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(long complaintId) {
        this.complaintId = complaintId;
    }

    public ComplaintStatus getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(ComplaintStatus complaintStatus) {
        this.complaintStatus = complaintStatus;
    }
}
