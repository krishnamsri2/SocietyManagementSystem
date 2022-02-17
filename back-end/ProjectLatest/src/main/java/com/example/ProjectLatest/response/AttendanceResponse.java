package com.example.ProjectLatest.response;

import java.util.Date;

public class AttendanceResponse {

    private long attendId;
    private Date punchIn;
    private Date punchOut;

    public AttendanceResponse(long attendId, Date punchIn, Date punchOut) {
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

    public Date getPunchIn() {
        return punchIn;
    }

    public void setPunchIn(Date punchIn) {
        this.punchIn = punchIn;
    }

    public Date getPunchOut() {
        return punchOut;
    }

    public void setPunchOut(Date punchOut) {
        this.punchOut = punchOut;
    }
}
