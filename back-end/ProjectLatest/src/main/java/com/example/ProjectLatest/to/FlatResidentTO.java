package com.example.ProjectLatest.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlatResidentTO {
    private long flatResId;
    @JsonProperty
    private boolean isOwner;
    @JsonProperty
    private boolean isTenant;
    private String flatNo;
    private String towerName;
    private long userDetailId;

    public long getFlatResId() {
        return flatResId;
    }

    public void setFlatResId(long flatResId) {
        this.flatResId = flatResId;
    }

    public boolean getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(boolean owner) {
        this.isOwner = owner;
    }

    public boolean getIsTenant() {
        return isTenant;
    }

    public void setIsTenant(boolean tenant) {
        this.isTenant = tenant;
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

    public long getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(long userDetailId) {
        this.userDetailId = userDetailId;
    }
}
