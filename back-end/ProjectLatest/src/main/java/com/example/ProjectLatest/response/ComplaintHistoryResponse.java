package com.example.ProjectLatest.response;

import com.example.ProjectLatest.entity.ComplaintStatus;

import java.util.Date;

public class ComplaintHistoryResponse
{
    private ComplaintStatus complaintStatus;
    private Date modifiedStatus;
    private String workerAssigned;
    private Long workerMobileNo;

    public ComplaintHistoryResponse(ComplaintStatus complaintStatus, Date modifiedStatus) {
        this.complaintStatus = complaintStatus;
        this.modifiedStatus = modifiedStatus;
        this.workerAssigned = "NA";
        this.workerMobileNo = null;
    }

    public ComplaintStatus getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(ComplaintStatus complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    public Date getModifiedStatus() {
        return modifiedStatus;
    }

    public void setModifiedStatus(Date modifiedStatus) {
        this.modifiedStatus = modifiedStatus;
    }

    public String getWorkerAssigned() {
        return workerAssigned;
    }

    public void setWorkerAssigned(String workerAssigned) {
        this.workerAssigned = workerAssigned;
    }

    public Long getWorkerMobileNo() {
        return workerMobileNo;
    }

    public void setWorkerMobileNo(Long workerMobileNo) {
        this.workerMobileNo = workerMobileNo;
    }
}
