package com.example.ProjectLatest.response;

public class AnnouncementResponse {

    private String announcementDetail;
    private long  announcementId;

    public AnnouncementResponse(String announcementDetail, long announcementId) {
        this.announcementDetail = announcementDetail;
        this.announcementId = announcementId;
    }

    public String getAnnouncementDetail() {
        return announcementDetail;
    }

    public void setAnnouncementDetail(String announcementDetail) {
        this.announcementDetail = announcementDetail;
    }

    public long getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(long announcementId) {
        this.announcementId = announcementId;
    }
}
