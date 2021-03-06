package com.example.ProjectLatest.response;

import com.example.ProjectLatest.entity.ComplaintStatus;

public class ComplaintWorkerResponse
{
    private String complaintDetail;
    private long complaintId;
    private ComplaintStatus complaintStatus;
    private String type;
    private String flatNo;
    private String towerName;

    public ComplaintWorkerResponse(String complaintDetail, long complaintId,ComplaintStatus complaintStatus, String type,String flatNo, String towerName) {
        this.complaintDetail = complaintDetail;
        this.complaintId = complaintId;
        this.complaintStatus = complaintStatus;
        this.type = type;
        this.flatNo = flatNo;
        this.towerName = towerName;
    }

    public String getComplaintDetail() {
        return complaintDetail;
    }

    public void setComplaintDetail(String complaintDetail) {
        this.complaintDetail = complaintDetail;
    }

    public long getComplaintId() {
        return complaintId;
    }

    public ComplaintStatus getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(ComplaintStatus complaintStatus) {
        this.complaintStatus = complaintStatus;
    }
    public void setComplaintId(long complaintId) {
        this.complaintId = complaintId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName;
    }
}
