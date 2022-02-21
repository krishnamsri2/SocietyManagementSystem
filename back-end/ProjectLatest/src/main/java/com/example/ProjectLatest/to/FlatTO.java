package com.example.ProjectLatest.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlatTO {
    private long flatId;
    private String flatNo;
    @JsonProperty
    private boolean status;
    private int numberOfOccupant;

    public long getFlatId() {
        return flatId;
    }

    public void setFlatId(long flatId) {
        this.flatId = flatId;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getNumberOfOccupant() {
        return numberOfOccupant;
    }

    public void setNumberOfOccupant(int numberOfOccupant) {
        this.numberOfOccupant = numberOfOccupant;
    }
}
