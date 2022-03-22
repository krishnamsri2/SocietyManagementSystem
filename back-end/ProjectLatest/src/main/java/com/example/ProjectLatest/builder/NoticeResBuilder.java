package com.example.ProjectLatest.builder;

import com.example.ProjectLatest.response.NoticeResponse;

import java.util.Date;

public class NoticeResBuilder {
    private long noticeId;
    private String noticeTitle;
    private String noticeDetail;
    private long createdBy;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isDeleted;

    public NoticeResBuilder setNoticeId(long noticeId) {
        this.noticeId = noticeId;
        return this;
    }

    public NoticeResBuilder setNoticeDetail(String noticeDetail) {
        this.noticeDetail = noticeDetail;
        return this;
    }


    public NoticeResBuilder setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
        return this;
    }
    public NoticeResBuilder setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public NoticeResBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public NoticeResBuilder setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public NoticeResBuilder setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public NoticeResponse getResponse(){
        return new NoticeResponse(noticeId,noticeTitle,noticeDetail,createdBy,createdDate,updatedDate,isDeleted);
    }
}
