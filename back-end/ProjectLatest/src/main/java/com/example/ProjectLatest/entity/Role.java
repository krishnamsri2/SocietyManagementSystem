package com.example.ProjectLatest.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.*;
@Entity
@Table(name="Role")
public class Role
{
	private  String roleDescription;
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long roleId;
	private String role;
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
	private Boolean isMenuAssigned;
	@ManyToMany(mappedBy = "roles")
	@JsonBackReference
	private Set<UserDetails> userDetails = new HashSet<UserDetails>();

	public Role() {
	}

	public Role(RoleType roleType,String roleDescription, String role, long createdBy) {
		super();
		this.roleType = roleType;
		this.role = role;
		this.roleDescription = roleDescription;
		this.createdBy = createdBy;
		this.modifiedBy = createdBy;
		this.createDate = new Date();
		this.modifyDate = new Date();
		this.isDeleted = false;
		this.isActive = true;
		this.isMenuAssigned=false;
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


	public Boolean getIsMenuAssigned() {
		return isMenuAssigned;
	}

	public void setIsMenuAssigned(Boolean menuAssigned) {
		setModifyDate();
		isMenuAssigned = menuAssigned;
	}
}