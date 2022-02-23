package com.example.ProjectLatest.response;

import java.util.Date;

public class SocietyResponse {
    private String societyName;
    private long createdBy;
    private Date createdDate;

    public SocietyResponse(String societyName, long createdBy, Date createdDate) {
        this.societyName = societyName;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
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
}
