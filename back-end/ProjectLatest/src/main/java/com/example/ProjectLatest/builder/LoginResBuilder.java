package com.example.ProjectLatest.builder;

import com.example.ProjectLatest.response.LoginResponse;

public class LoginResBuilder {
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String emailId;
    private long societyId;
    private long userId;
    private long userDetailId;

    public LoginResBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public LoginResBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LoginResBuilder setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public LoginResBuilder setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public LoginResBuilder setSocietyId(long societyId) {
        this.societyId = societyId;
        return this;
    }

    public LoginResBuilder setUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public LoginResponse getResponse(){
        return new LoginResponse(firstName,lastName,phoneNumber,emailId,societyId,userId,userDetailId);
    }

    public LoginResBuilder setUserDetailId(long userDetailsId) {
        this.userDetailId=userDetailsId;
        return this;
    }
}
