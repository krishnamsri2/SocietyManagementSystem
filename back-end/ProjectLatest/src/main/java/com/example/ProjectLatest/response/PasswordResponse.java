package com.example.ProjectLatest.response;

public class PasswordResponse {
    private  String ack;

    public PasswordResponse(String ack) {
        this.ack = ack;
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }
}
