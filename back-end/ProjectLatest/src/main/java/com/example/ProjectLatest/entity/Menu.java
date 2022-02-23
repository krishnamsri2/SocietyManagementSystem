package com.example.ProjectLatest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Menu")
public class Menu 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long menuId;
	//
	private String Url;
	
	private long createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdDate",nullable=false)
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modifiedDate",nullable=false)
	private Date modifiedDate;
	
	private Boolean isDeleted;
	
	private Boolean isActive;
	
	@OneToOne(mappedBy="menu")
	private MenuSecurity menuSecurity;
	
	//private MenuSecurity ms;  from MenuSecurity table

	public Menu() {
	}

	public Menu(String url, long createdBy) {
		super();
		this.Url = url;
		this.createdBy = createdBy;
		this.createDate = new Date();
		this.modifiedDate = new Date();
		this.isDeleted = false;
		this.isActive = true;
	}

	public long getMenuId() {
		return menuId;
	}
	
	public String getUrl() {
		
		return Url;
	}
	public void setUrl(String url) {
		setModifiedDate();
		this.Url= url;

	}
	
	public long getCreatedBy() {
		return createdBy;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public Date getModifiedDate() {
		return modifiedDate;
	}
	
	public void setModifiedDate() {
		this.modifiedDate = new Date();
	}
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(Boolean isDeleted) {
		setModifiedDate();
		this.isDeleted = isDeleted;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive) {
		setModifiedDate();
		this.isActive = isActive;
	}



}
