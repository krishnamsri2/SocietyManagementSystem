package com.example.ProjectLatest.entity;


import javax.persistence.*;
import java.util.Date;


@Entity
public class Notice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long noticeId;
	
	private String noticeDetail;
	private long userId;
	private long createdBy;
	private long modifyBy;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedDate", nullable = false)
	private Date CreatedDate;
	
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdatedDate", nullable = false)
	private Date updatedDate;
	
	
	private boolean isDeleted;
	private boolean isActive;

	public Notice() {
	}

	public Notice(String noticeDetail, long createdBy,long userId) {
		
		this.noticeDetail = noticeDetail;
		this.createdBy = createdBy;
		this.modifyBy = createdBy;
		this.CreatedDate = new Date();
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
		return CreatedDate;
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
