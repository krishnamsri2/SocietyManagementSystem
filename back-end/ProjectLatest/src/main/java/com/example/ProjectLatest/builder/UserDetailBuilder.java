package com.example.ProjectLatest.builder;

import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.entity.UserDetails;

public class UserDetailBuilder {
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String emailId;
    private long createdBy;
    private User user;

    public UserDetailBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserDetailBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserDetailBuilder setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserDetailBuilder setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public UserDetailBuilder setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public UserDetailBuilder setUser(User user) {
        this.user = user;
        return this;
    }

    public UserDetails getResponse(){
        return new UserDetails(firstName,lastName,phoneNumber,emailId,createdBy,user);
    }
}
