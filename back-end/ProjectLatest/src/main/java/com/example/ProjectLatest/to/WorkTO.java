package com.example.ProjectLatest.to;

import com.example.ProjectLatest.entity.ComplaintStatus;

public class WorkTO
{
    private long complaintId;
    private long userId;
    private ComplaintStatus complaintStatus;

    public long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(long complaintId) {
        this.complaintId = complaintId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public ComplaintStatus getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(ComplaintStatus complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

}
