package com.example.ProjectLatest.response;

import java.util.Date;

public class TowerResponse {
    private long towerId;
    private String towerName;
    private long createdBy;
    private Date createdDate;

    public TowerResponse(String towerName, long createdBy, Date createdDate,long towerId) {
        this.towerName = towerName;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.towerId=towerId;
    }

    public long getTowerId() {
        return towerId;
    }

    public void setTowerId(long towerId) {
        this.towerId = towerId;
    }

    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName;
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
