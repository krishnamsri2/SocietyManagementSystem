package com.example.ProjectLatest.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="UserDetails")
public class UserDetails
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userDetailsId;

	private String firstName;
	private String lastName;
	@Column(unique = true)
	private long phoneNumber;
	@Column(unique = true)
	private String emailId;
	
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
	
	@OneToOne
	@JoinColumn(name="userID")  // ForeignKey from User table
	private User user;
	
	@ManyToMany
	@JoinTable(
			name = "userDetails_role",
			joinColumns = {@JoinColumn(name = "userDetailsId")},
			inverseJoinColumns = {@JoinColumn(name="role_id")}
	)
	private Set<Role> roles = new HashSet<Role>();

	@OneToMany(mappedBy = "userDetail", cascade={CascadeType.REMOVE} )
	private Set<FlatResidents> residents = new HashSet<FlatResidents>();

	@OneToMany(mappedBy = "usd")
    private Set<Attendance> setAttendance = new HashSet<Attendance>();

	public UserDetails() {
	}

	public UserDetails(String firstName, String lastName, long phoneNumber, String emailId,long createdBy,User user) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.createdBy = createdBy;
		this.modifiedBy = createdBy;
		this.createDate = new Date();
		this.updateDate = new Date();
		this.isDeleted = false;
		this.isActive = true;
		this.user = user;
	}

	public long getUserDetailsId() {
		return userDetailsId;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName,long modifiedBy) {
		setUpdateDate();
		setModifiedBy(modifiedBy);
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName,long modifiedBy) {
		setUpdateDate();
		setModifiedBy(modifiedBy);
		this.lastName = lastName;
	}

	public User getUser() {
		return user;
	}


	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(long phoneNumber,long modifiedBy) {
		setUpdateDate();
		setModifiedBy(modifiedBy);
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId,long modifiedBy) {
		setUpdateDate();
		setModifiedBy(modifiedBy);
		this.emailId = emailId;
	}
	
	public long getCreatedBy() {
		return createdBy;
	}
	
	
	public long getModifiedBy() {
		return modifiedBy;
	}
	
	public void setModifiedBy(long modifiedBy) {
		setUpdateDate();
		this.modifiedBy = modifiedBy;
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
	
	public void setIsDeleted(Boolean isDeleted,long modifiedBy) {
		setUpdateDate();
		setModifiedBy(modifiedBy);
		this.isDeleted = isDeleted;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive,long modifiedBy) {
		setUpdateDate();
		setModifiedBy(modifiedBy);
		this.isActive = isActive;
	}
	
	public Set<FlatResidents> getFlatResidents() {
		return residents;
	}
	
	public void addFlatResidents(FlatResidents resident) {
		setUpdateDate();
		residents.add(resident);
		resident.setUserDetail(this);
	}

	public Set<Attendance> getSetAttendance() {
		return setAttendance;
	}

	public void addAttendance(Attendance attendance) {
		setUpdateDate();
		setAttendance.add(attendance);
		attendance.setUsd(this);
	}
}
