package com.example.ProjectLatest.response;

public class ChangePasswordResponse {
    private String ack;

    public ChangePasswordResponse(String ack) {
        this.ack = ack;
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }
}
