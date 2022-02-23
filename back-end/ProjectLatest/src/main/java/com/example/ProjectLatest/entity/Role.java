package com.example.ProjectLatest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Role")
public class Role 
{
<<<<<<< HEAD
=======
	private  String roleDescription;
>>>>>>> 6b816359d0104da0ba74f438b7e1778ff0a99757
	@Enumerated(EnumType.STRING)
	private RoleType roleType;



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long roleId;
	
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
	
	@ManyToMany(mappedBy = "roles")
	@JsonBackReference
	private Set<UserDetails> userDetails = new HashSet<UserDetails>();
	
	@OneToOne(mappedBy="role")
	private MenuSecurity menuSecurity;


	public Role() {
	}

	public Role(RoleType roleType,String roleDescription, String role, long createdBy) {
		super();
		this.roleType = roleType;
		this.role = role;
<<<<<<< HEAD
		this.roleDescription=roleDescription;
=======
		this.roleDescription = roleDescription;
>>>>>>> 6b816359d0104da0ba74f438b7e1778ff0a99757
		this.createdBy = createdBy;
		this.modifiedBy = createdBy;
		this.createDate = new Date();
		this.modifyDate = new Date();
		this.isDeleted = false;
		this.isActive = true;
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

	public Long getRoleId() {
		return roleId;
	}
	
	
	public String getRole() {
		
		return role;
	}
	
	public void setRole(String role) {
		setModifyDate();
		this.role = role;
	}
	
	
	public Set<UserDetails> getUserDetails() {
		
		return userDetails;
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
	
	public void setIsDeleted(Boolean value) {
		setModifyDate();
		this.isDeleted = value;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive) {
		setModifyDate();
		this.isActive = isActive;
	}


	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
}
