package com.example.ProjectLatest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="User")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	private String password;
	private Boolean status; // Active or Inactive
	@Column(unique = true,nullable = false)
	private String emailId;
	@Column(nullable = false)
	private long societyId;

	private String resetToken;

	private Long createdBy;
	private Long modifiedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdDate",nullable=false)
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updatedDate",nullable=false)
	private Date updated;
	
	private Boolean isDeleted;
	private Boolean isActive;
	
	@OneToOne(mappedBy="user",cascade = CascadeType.ALL)
	private UserDetails usd;
	
	public UserDetails getUsd() {
		return usd;
	}

	public User() {
		
	}

	public User(String password,String emailId,long createdBy,long societyId) {
		super();
		this.password = password;
		this.status = false;
		this.createdBy = createdBy;
		this.modifiedBy = createdBy;
		this.created = new Date();
		this.updated = new Date();
		this.isDeleted = false;
		this.isActive = true;
		this.emailId = emailId;
		this.societyId = societyId;
	}

	public String getResetToken() {

		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public long getSocietyId() {
		return societyId;
	}

	public void setSocietyId(long societyId) {
		this.societyId = societyId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getUserId() {
		return userId;
	}
	

	
	public String getPassword() {
		
		return password;
	}
	
	public void setPassword(String password,long modifiedBy) {
		setUpdated();
		setModifiedBy(modifiedBy);
		this.password = password;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status,long modifiedBy) {
		setUpdated();
		setModifiedBy(modifiedBy);
		this.status = status;
	}
	
	public long getCreatedBy() {
		return createdBy;
	}
	
	
	
	public long getModifiedBy() {
		return modifiedBy;
	}
	
	public void setModifiedBy(long modifyBy) {
		setUpdated() ;
		this.modifiedBy = modifyBy;
	}
	
	public Date getCreatedDate() {
		return created;
	}
	
	
	
	public Date getUpdated() {
		return updated;
	}
	
	public void setUpdated() {
		this.updated = new Date();
	}
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(Boolean isDeleted) {
		setUpdated();
		setModifiedBy(modifiedBy);
		this.isDeleted = isDeleted;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive,long modifiedBy) {
		setUpdated();
		setModifiedBy(modifiedBy);
		this.isActive = isActive;
	}

}
