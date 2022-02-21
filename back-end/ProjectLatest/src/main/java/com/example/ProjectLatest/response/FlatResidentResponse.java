package com.example.ProjectLatest.response;

public class FlatResidentResponse {
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

    public FlatResidentResponse(boolean isOwner, boolean isTenant,String towerName, long flatId,String flatNo, long userDetailId, String firstName, String lastName, long phoneNumber, String emailId) {
        this.isOwner = isOwner;
        this.isTenant = isTenant;
        this.towerName = towerName;
        this.flatId = flatId;
        this.flatNo = flatNo;
        this.userDetailId = userDetailId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }

    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

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
}
