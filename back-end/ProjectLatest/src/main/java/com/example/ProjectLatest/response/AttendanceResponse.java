package com.example.ProjectLatest.response;

import java.util.Date;

public class AttendanceResponse {

    private long attendId;
    private String punchIn;
    private String punchOut;

    public AttendanceResponse(long attendId, String punchIn, String punchOut) {
        this.attendId = attendId;
        this.punchIn = punchIn;
        this.punchOut = punchOut;
    }

    public long getAttendId() {
        return attendId;
    }

    public void setAttendId(long attendId) {
        this.attendId = attendId;
    }

    public String getPunchIn() {
        return punchIn;
    }

    public void setPunchIn(String punchIn) {
        this.punchIn = punchIn;
    }

    public String getPunchOut() {
        return punchOut;
    }

    public void setPunchOut(String punchOut) {
        this.punchOut = punchOut;
    }
}
