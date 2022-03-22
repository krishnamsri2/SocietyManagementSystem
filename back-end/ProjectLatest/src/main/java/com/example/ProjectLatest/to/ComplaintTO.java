package com.example.ProjectLatest.to;

import com.example.ProjectLatest.entity.ComplaintStatus;

public class ComplaintTO {

    private long flatId;
    private long userId;
    private String complaintDetails;
    private long  complaintId;
    private String type;

    private ComplaintStatus complaintStatus;


    public long getFlatId() {
        return flatId;
    }

    public String getComplaintDetails() {
        return complaintDetails;
    }

    public void setComplaintDetails(String complaintDetails) {
        this.complaintDetails = complaintDetails;
    }

    public long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(long ComplaintId) {
        this.complaintId = ComplaintId;
    }

    public long getFlatIdId() {
        return flatId;
    }


    public String getType() {
        return type;
    }

    public ComplaintStatus getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(ComplaintStatus complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
