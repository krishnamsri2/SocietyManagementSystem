package com.example.ProjectLatest.response;

public class ComplaintResponse {
    private String type;
    private long  complaintId;

    public ComplaintResponse(String type, long complaintId) {
        this.type = type;
        this.complaintId = complaintId;
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
}
