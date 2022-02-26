package com.example.ProjectLatest.response;

public class LoginResponse {
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String emailId;
    private long societyId;
    private long userId;

    public LoginResponse(String firstName, String lastName, long phoneNumber, String emailId, long societyId, long userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.societyId = societyId;
        this.userId = userId;
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
        this.lastName = lastName;
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

    public long getSocietyId() {
        return societyId;
    }

    public void setSocietyId(long societyId) {
        this.societyId = societyId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
