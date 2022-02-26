package com.example.ProjectLatest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Role")
public class Role 
{
<<<<<<< HEAD
	//private  String roleDescription;
=======
	private  String roleDescription;
>>>>>>> 2d17a4c1b374e9febbda54c5abdcc254b56e488e
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
<<<<<<< HEAD
	
	@OneToOne(mappedBy="role")
	private MenuSecurity menuSecurity;
=======
>>>>>>> 2d17a4c1b374e9febbda54c5abdcc254b56e488e

	@ManyToMany
	@JoinTable(
			name = "MenuSecurity",
			joinColumns = {@JoinColumn(name = "roleId")},
			inverseJoinColumns = {@JoinColumn(name="menuId")}
	)
	private List<Menu> menus = new ArrayList<Menu>();

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

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
