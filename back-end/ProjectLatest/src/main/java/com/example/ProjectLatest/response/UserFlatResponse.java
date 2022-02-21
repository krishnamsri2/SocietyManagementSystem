package com.example.ProjectLatest.response;

public class UserFlatResponse {
        private String towerName;
        private String flatNo;

    public UserFlatResponse(String towerName, String flatNo) {
        this.towerName = towerName;
        this.flatNo = flatNo;
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
}
