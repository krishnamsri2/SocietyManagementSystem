package com.example.ProjectLatest.response;

public class FlatResidentResponse {
    private long flatResId;
    private boolean isOwner;
    private boolean isTenant;
    private String flatNo;
    private String towerName;

    public FlatResidentResponse(long flatResId ,boolean isOwner, boolean isTenant, String flatNo, String towerName) {
        this.flatResId = flatResId;
        this.isOwner = isOwner;
        this.isTenant = isTenant;
        this.flatNo = flatNo;
        this.towerName = towerName;
    }

    public long getFlatResId() {
        return flatResId;
    }

    public void setFlatResId(long flatResId) {
        this.flatResId = flatResId;
    }

    public boolean getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(boolean isOwner) {
        this.isOwner = isOwner;
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
}
