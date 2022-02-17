package com.example.ProjectLatest.response;

public class FlatResponse {
    private String flatNo;
    private boolean Status;
    private int numberOfOccupants;

    public FlatResponse(String flatNo, boolean status, int numberOfOccupants) {
        this.flatNo = flatNo;
        Status = status;
        this.numberOfOccupants = numberOfOccupants;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public int getNumberOfOccupants() {
        return numberOfOccupants;
    }

    public void setNumberOfOccupants(int numberOfOccupants) {
        this.numberOfOccupants = numberOfOccupants;
    }
}
