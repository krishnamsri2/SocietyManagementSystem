package com.example.ProjectLatest.builder;

import com.example.ProjectLatest.response.FlatResidentResponse;

public class FlatResidentResBuilder {
    private boolean isOwner;
    private boolean isTenant;
    private long flatId;
    private String flatNo;
    private String towerName;
    private long userDetailId;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String emailId;

    public FlatResidentResBuilder setIsOwner(boolean owner) {
        this.isOwner = owner;
        return this;
    }

    public FlatResidentResBuilder setIsTenant(boolean tenant) {
        this.isTenant = tenant;
        return this;
    }

    public FlatResidentResBuilder setFlatId(long flatId) {
        this.flatId = flatId;
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

    public FlatResidentResBuilder setUserDetailId(long userDetailId) {
        this.userDetailId = userDetailId;
        return this;
    }

    public FlatResidentResBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public FlatResidentResBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public FlatResidentResBuilder setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public FlatResidentResBuilder setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public FlatResidentResponse getResponse(){
        return new FlatResidentResponse(isOwner,isTenant,towerName,flatId,flatNo,userDetailId,firstName,lastName,phoneNumber,emailId);
    }
}
