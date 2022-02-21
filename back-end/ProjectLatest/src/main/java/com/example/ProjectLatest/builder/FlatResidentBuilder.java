package com.example.ProjectLatest.builder;

import com.example.ProjectLatest.entity.Flat;
import com.example.ProjectLatest.entity.FlatResidents;
import com.example.ProjectLatest.entity.UserDetails;

public class FlatResidentBuilder {

    private boolean isOwner;
    private boolean isTenant;
    private long createdBy;
    private Flat flat;
    private UserDetails userDetail;

    public FlatResidentBuilder setOwner(boolean owner) {
        isOwner = owner;
        return this;
    }

    public FlatResidentBuilder setTenant(boolean tenant) {
        isTenant = tenant;
        return this;
    }

    public FlatResidentBuilder setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public FlatResidentBuilder setFlat(Flat flat) {
        this.flat = flat;
        return this;
    }

    public FlatResidentBuilder setUserDetail(UserDetails userDetail) {
        this.userDetail = userDetail;
        return this;
    }

    public FlatResidents getResponse(){
        return new FlatResidents(isOwner,isTenant,createdBy,flat,userDetail);
    }
}
