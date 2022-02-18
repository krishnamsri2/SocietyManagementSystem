package com.example.ProjectLatest.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Attendance_Table")
public class Attendance 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long attendId;
	
	private Date punchIn;
	private Date punchOut;
	
	
	private long createdBy;
	private long modifiedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdDate",nullable=false)
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updatedDate",nullable=false)
	private Date updateDate;
	
	
	private Boolean isDeleted;
	private Boolean isActive;
	
	
	private Boolean punchInFlag;
	private Boolean punchOutFlag;
	
	@ManyToOne
	@JoinColumn(name="UserDetailsID")
	private UserDetails usd;
	
	public Attendance()
	{
		
	}
	
	public Attendance(UserDetails usd) {
		super();
		this.usd = usd;
		this.createdBy = usd.getUser().getUserId();
		this.modifiedBy = usd.getUser().getUserId();
		this.createDate = new Date();
		this.updateDate = new Date();
		this.isDeleted = false;
		this.isActive = true;
		this.punchInFlag=false;
		this.punchOutFlag=false;
	}
	
	public long getAttendId() {
		return attendId;
	}
	public Date getPunchIn() {
		return punchIn;
	}
	public void setPunchIn() 
	{
		if(punchInFlag==false)
		{
		this.punchIn = new Date();
		punchInFlag=true;
		}

	}
	public Date getPunchOut() {
		return punchOut;
	}
	public void setPunchOut() 
	{
		if(punchOutFlag==false&&punchInFlag==true)
		{
		this.punchOut = new Date();
		punchOutFlag = true;
		}
	}
	public UserDetails getUser() {
		return usd;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public long getModifiedBy() {
		return modifiedBy;
	}
	
	
	public Date getCreateDate() {
		return createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate() {
		this.updateDate = new Date();
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		setUpdateDate();
		this.isDeleted = isDeleted;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		setUpdateDate();
		this.isActive = isActive;
	}


    public void setUsd(UserDetails userDetails)
	{
		this.usd = userDetails;
    }
}
