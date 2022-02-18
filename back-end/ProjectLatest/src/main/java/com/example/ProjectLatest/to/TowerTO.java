package com.example.ProjectLatest.to;

public class TowerTO {
    private long towerId;
    private String towerName;
    boolean isDeleted;
    boolean isActive;

    public long getTowerId() {
        return towerId;
    }

    public void setTowerId(long towerId) {
        this.towerId = towerId;
    }

    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
