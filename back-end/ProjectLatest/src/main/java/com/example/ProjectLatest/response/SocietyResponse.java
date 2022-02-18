package com.example.ProjectLatest.response;

import java.util.Date;

public class SocietyResponse {
    private long societyId;
    private String societyName;
    private long createdBy;
    private Date createdDate;



    public SocietyResponse(String societyName, long createdBy, Date createdDate,long societyId) {
        this.societyName = societyName;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.societyId=societyId;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public long getSocietyId() {
        return societyId;
    }

    public void setSocietyId(long societyId) {
        this.societyId = societyId;
    }
}
