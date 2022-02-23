package com.example.ProjectLatest.builder;

import com.example.ProjectLatest.response.FlatResidentResponse;

public class FlatResidentResBuilder {
    private long flatResId;
    private boolean isOwner;
    private boolean isTenant;
    private String flatNo;
    private String towerName;
    private Boolean isDeleted;

    public FlatResidentResBuilder setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public FlatResidentResBuilder setFlatResId(long flatResId) {
        this.flatResId = flatResId;
        return this;
    }

    public FlatResidentResBuilder setIsOwner(boolean owner) {
        this.isOwner = owner;
        return this;
    }

    public FlatResidentResBuilder setIsTenant(boolean tenant) {
        this.isTenant = tenant;
        return this;
    }

    public FlatResidentResBuilder setFlatNo(String flatNo) {
        this.flatNo = flatNo;
        return this;
    }

    public FlatResidentResBuilder setTowerName(String towerName) {
        this.towerName = towerName;
        return this;
    }

    public FlatResidentResponse getResponse(){
        return new FlatResidentResponse(flatResId,isOwner,isTenant,towerName,flatNo,isDeleted);
    }
}
