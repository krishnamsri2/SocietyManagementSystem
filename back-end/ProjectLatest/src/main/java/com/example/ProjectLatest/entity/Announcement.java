package com.example.ProjectLatest.entity;




import javax.persistence.*;
import java.util.Date;

@Entity
public class Announcement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long annoucementId;
	private String announcementDetail;
	private long userId;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="flatResId")
	private FlatResidents flatResidents;
	
	private long createdBy;
	private long modifyBy;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedDate", nullable = false)
	private Date createdDate;
	
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdatedDate", nullable = false)
	private Date modifyDate;
	
	
	private boolean isDeleted;
	private boolean isActive;

	public Announcement() {
	}

	public Announcement(String announcementDetail, long createdBy) {
		
		this.announcementDetail = announcementDetail;
		this.createdBy = createdBy;
		this.modifyBy = createdBy;
		this.createdDate = new Date();
		this.modifyDate = new Date();
		this.isDeleted = false;
		this.isActive = true;
	}

	protected void onUpdate() {
        modifyDate = new Date();
    }
	
	public long getannoucementId() {
		return annoucementId;
	}
	
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		onUpdate();
		userId = userId;
	}
	
	public String getAnnouncementDetail() {
		return announcementDetail;
	}
	
	public void setAnnouncementDetail(String announcementDetail) {
       onUpdate();
		this.announcementDetail = announcementDetail;

	}
	
	public long getCreatedBy() {
		return createdBy;
	}
	
	public long getModifyBy() {
		return modifyBy;
	}
	
	public void setModifyBy(long modify) {
		modifyBy = modify;
	}
	
	
	public Date getCreatedDate() {
		return createdDate;
	}
	

	
	public Date getModifyDate() {
		return modifyDate;
	}
	
	
	public boolean isIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(boolean IsDeleted) {
		onUpdate();
		isDeleted = IsDeleted;
	}
	
	public boolean isIdActive() {
		return isActive;
	}
	
	public void setIsActive(boolean IsActive) {
		onUpdate();
		isActive = IsActive;
	}

	public FlatResidents getFlatResidents() {
		return flatResidents;
	}

	public void setFlatResidents(FlatResidents flatResidents) {
		onUpdate();
		this.flatResidents = flatResidents;
	}

	
}
