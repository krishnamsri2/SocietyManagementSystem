package com.example.ProjectLatest.to;

public class FlatResidentTO {
    private boolean isOwner;
    private boolean isTenant;
    private long flatId;
    private long userDetailId;

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public boolean isTenant() {
        return isTenant;
    }

    public void setTenant(boolean tenant) {
        isTenant = tenant;
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
