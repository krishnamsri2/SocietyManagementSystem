package com.example.ProjectLatest.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Role")
public class Role 
{
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleId;
	
	private String role;
	private String roleDescription;



	private long createdBy;
	private long modifiedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdDate",nullable=false)
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updatedDate",nullable=false)
	private Date modifyDate;
	
	private Boolean isDeleted;
	private Boolean isActive;
	
	@OneToOne
	@JoinColumn(name="userDetailsID")	// ForeignKey
	@JsonManagedReference
	private UserDetails userDetails;  
	
	@OneToOne(mappedBy="role")
	private MenuSecurity menuSecurity;


	public Role() {
	}

	public Role(RoleType roleType,String roleDescription, String role, long createdBy, UserDetails userDetails) {
		super();
		this.roleType = roleType;
		this.roleDescription = roleDescription;
		this.role = role;
		this.createdBy = createdBy;
		this.modifiedBy = createdBy;
		this.createDate = new Date();
		this.modifyDate = new Date();
		this.isDeleted = false;
		this.isActive = true;
		this.userDetails = userDetails;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		setModifyDate();
		this.roleType = roleType;
	}

	public int getRoleId() {
		return roleId;
	}
	
	
	public String getRole() {
		
		return role;
	}
	
	public void setRole(String role) {
		setModifyDate();
		this.role = role;
	}
	
	
	public UserDetails getUser() {
		
		return userDetails;
	}

	public void setUser(UserDetails user) {
		setModifyDate();
		this.userDetails = user;
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
	
	
	public Date getModifyDate() {
		return modifyDate;
	}
	
	public void setModifyDate() {
		this.modifyDate = new Date();
	}
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(Boolean isDeleted) {
		setModifyDate();
		this.isDeleted = isDeleted;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive) {
		setModifyDate();
		this.isActive = isActive;
	}
	
	
}
