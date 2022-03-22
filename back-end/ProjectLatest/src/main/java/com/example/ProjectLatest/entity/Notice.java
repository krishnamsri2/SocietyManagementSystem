package com.example.ProjectLatest.entity;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Notice")
public class Notice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "noticeId")
	private long noticeId;
	@Column(name = "noticeTitle")
	private String noticeTitle;
	@Column(name = "noticeDetail")
	private String noticeDetail;
	@Column(name = "userId")
	private long userId;
	@Column(name = "createdBy")
	private long createdBy;
	@Column(name = "modifyBy")
	private long modifyBy;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedDate", nullable = false)
	private Date createdDate;
	
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdatedDate", nullable = false)
	private Date updatedDate;
	
	@Column(name = "isDeleted")
	private boolean isDeleted;
	@Column(name = "isActive")
	private boolean isActive;

	public Notice() {
	}

	public Notice(String noticeTitle, String noticeDetail, long userId) {
		this.noticeTitle = noticeTitle;
		this.noticeDetail = noticeDetail;
		this.createdBy = userId;
		this.modifyBy = userId;
		this.createdDate = new Date();
		this.updatedDate = new Date();
		this.isDeleted = false;
		this.isActive = true;
		this.userId = userId;
	}

	public long getNoticeId() {
		return noticeId;
	}

	public String getNoticeDetail() {
		return noticeDetail;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public void setNoticeDetail(String noticeDetail) {
		setUpdatedDate();
		this.noticeDetail = noticeDetail;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		setUpdatedDate();
		this.userId = userId;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(long modifyBy) {
		setUpdatedDate();
		this.modifyBy = modifyBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate() {
		this.updatedDate = new Date();
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		setUpdatedDate();
		this.isDeleted = isDeleted;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		setUpdatedDate();
		this.isActive = isActive;
	}
	
}
