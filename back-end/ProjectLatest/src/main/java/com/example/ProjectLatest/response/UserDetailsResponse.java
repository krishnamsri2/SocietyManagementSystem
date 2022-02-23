package com.example.ProjectLatest.response;

import java.util.List;

public class UserDetailsResponse {
    private long userDetailId;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String emailId;
    private Boolean isDeleted;

    public UserDetailsResponse(long userDetailId, String firstName, String lastName, long phoneNumber, String emailId ,Boolean isDeleted) {
        this.userDetailId = userDetailId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.isDeleted = isDeleted;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        this.isDeleted = deleted;
    }

    public long getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(long userDetailId) {
        this.userDetailId = userDetailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
