package com.example.ProjectLatest.response;

public class AnnouncementResponse {
    private String announcementTitle;
    private String announcementDetail;
    private long  announcementId;

    public AnnouncementResponse(String announcementTitle,String announcementDetail, long announcementId) {
        this.announcementTitle = announcementTitle;
        this.announcementDetail = announcementDetail;
        this.announcementId = announcementId;
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
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
