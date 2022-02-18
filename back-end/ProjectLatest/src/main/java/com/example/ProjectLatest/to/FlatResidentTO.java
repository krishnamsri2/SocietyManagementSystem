package com.example.ProjectLatest.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlatResidentTO {
    @JsonProperty
    private boolean isOwner;
    @JsonProperty
    private boolean isTenant;
    private long flatId;
    private long userDetailId;

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

    public long getFlatId() {
        return flatId;
    }

    public void setFlatId(long flatId) {
        this.flatId = flatId;
    }

    public long getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(long userDetailId) {
        this.userDetailId = userDetailId;
    }
}
