package com.example.ProjectLatest.response;

public class UserDetailsResponse {
    private long userDetailId;
    private String firstName;
    private String LastName;
    private long phoneNumber;
    private String emailId;
    private String password;

    public UserDetailsResponse(long userDetailId, String firstName, String lastName, long phoneNumber, String emailId, String password) {
        this.userDetailId = userDetailId;
        this.firstName = firstName;
        this.LastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.password = password;
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
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
