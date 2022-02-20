package com.example.ProjectLatest.builder;

import com.example.ProjectLatest.response.UserDetailsResponse;

import java.util.List;

public class UserDetailsResBuilder {
    private long userDetailId;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String emailId;
    private List<String> towerName;
    private List<String> flatNo;

    public UserDetailsResBuilder setUserDetailId(long userDetailId) {
        this.userDetailId = userDetailId;
        return this;
    }

    public UserDetailsResBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserDetailsResBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserDetailsResBuilder setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserDetailsResBuilder setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public UserDetailsResBuilder setTowerName(List<String> towerName) {
        this.towerName = towerName;
        return this;
    }

    public UserDetailsResBuilder setFlatNo(List<String> flatNo) {
        this.flatNo = flatNo;
        return this;
    }

    public UserDetailsResponse getResponse(){
        return new UserDetailsResponse(userDetailId,firstName,lastName,phoneNumber,emailId,towerName,flatNo);
    }
}
