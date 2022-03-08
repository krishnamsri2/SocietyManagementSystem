package com.example.ProjectLatest.to;

public class UserTO {
    private long userDetailId;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String emailId;
    private String societyName;
    //private String password;
//    private String towerName;
//    private String flatNo;

    public long getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(long userDetailId) {
        this.userDetailId = userDetailId;
    }

//    public String getTowerName() {
//        return towerName;
//    }
//
//    public void setTowerName(String towerName) {
//        this.towerName = towerName;
//    }
//
//    public String getFlatNo() {
//        return flatNo;
//    }
//
//    public void setFlatNo(String flatNo) {
//        this.flatNo = flatNo;
//    }


//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }


    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
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
