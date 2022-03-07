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
	
	private String punchIn;
	private String punchOut;
	private String punchTime;
	
	
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
		this.createdBy = usd.getUserDetailsId();
		this.modifiedBy = usd.getUserDetailsId();
		this.createDate = new Date();
		this.updateDate = new Date();
		this.isDeleted = false;
		this.isActive = true;
		this.punchInFlag=true;
		this.punchIn = createDate.toString();
		this.punchOutFlag=false;
		this.punchTime = createDate.toString().substring(0,10);
	}

	public String getPunchTime() {
		return punchTime;
	}

	public long getAttendId() {
		return attendId;
	}
	public String getPunchIn() {
		return punchIn;
	}

	public String getPunchOut() {
		return punchOut;
	}
	public void setPunchOut() 
	{
		setUpdateDate();
		if(punchInFlag==true)
		{
			Date date = new Date();
		this.punchOut = date.toString();
		punchOutFlag = true;
		}
	}
	public UserDetails getUser() {
		return usd;
	}

	public void setUsd(UserDetails usd) {
		this.usd = usd;
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


 
}
