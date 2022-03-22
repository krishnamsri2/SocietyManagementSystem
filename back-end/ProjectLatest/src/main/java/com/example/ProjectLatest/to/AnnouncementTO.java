package com.example.ProjectLatest.to;

public class AnnouncementTO {
    private String announcementTitle;
    private String announcementDetail;
    private long  announcementId;

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

    public void setAnnouncementId(long AnnouncementId) {
        this.announcementId = AnnouncementId;
    }
}
