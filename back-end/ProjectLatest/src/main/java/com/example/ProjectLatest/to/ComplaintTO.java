package com.example.ProjectLatest.to;

public class ComplaintTO {

    private String complaintDetail;
    private long  complaintId;
    private String type;
    private long flatId;

    public String getComplaintDetail() {
        return complaintDetail;
    }

    public void setComplaintDetail(String complaintDetail) {
        this.complaintDetail = complaintDetail;
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
}
