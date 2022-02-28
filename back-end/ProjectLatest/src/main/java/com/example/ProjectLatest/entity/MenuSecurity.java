package com.example.ProjectLatest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MenuSecurity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long menuSecurityID;
	private boolean isActive;
	private boolean isDeleted;
	private long modifyBy;
	private long createdBy;

//	@Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "createdDate", nullable = false)
//    private Date created;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "updatedDate", nullable = false)
//    private Date updated;
//
////    @OneToOne
////    @JoinColumn(name="RoleID")
////    private Role role;
////
////    @OneToOne
////    @JoinColumn(name="MenuID")
////    private Menu menu;
//
//	public MenuSecurity() {
//		super();
//	}
//
//
//	public MenuSecurity(Role role,Menu menu,long createdBy) {
//		super();
//		this.role = role;
//		this.menu = menu;
//		this.createdBy = createdBy;
//		this.created = new Date();
//		this.updated = new Date();
//		this.modifyBy=createdBy;
//		this.isActive=true;
//		this.isDeleted=true;
//	}
//	public Role getRole() {
//		return role;
//	}
//	public void setRole(Role role) {
//		this.role = role;
//	}
//
//	public Menu getMenu() {
//		return menu;
//	}
//
//	public void setMenu(Menu menu) {
//
//		this.menu = menu;
//	}
//
//
//	public long getMenuSecurityID()
//	{
//		return menuSecurityID;
//	}
//
//	public boolean isActive() {
//		return isActive;
//	}
//
//	public void setActive(boolean isActive) {
//		setUpdated();
//		this.isActive = isActive;
//	}
//
//	public boolean isDeleted() {
//		return isDeleted;
//	}
//
//	public void setDeleted(boolean isDeleted) {
//		setUpdated();
//		this.isDeleted = isDeleted;
//	}
//
//	public long getModifyBy() {
//		return modifyBy;
//	}
//
//	public void setModifyBy(int modifyBy) {
//		setUpdated();
//		this.modifyBy = modifyBy;
//	}
//
//	public long getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(int createdBy) {
//		setUpdated();
//		this.createdBy = createdBy;
//	}
//
//	public Date getCreated() {
//		return created;
//	}
//
//	public void setCreated(Date created) {
//		setUpdated();
//		this.created = created;
//	}
//
//	public Date getUpdated() {
//		return updated;
//	}
//
//	public void setUpdated() {
//		this.updated = new Date();
//	}
//



}
