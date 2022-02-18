package com.example.ProjectLatest.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
public class Society {
	private String societyName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Society_id")
	private long societyid;
	@Column(name="Created_by",nullable = false)
	private long createdby;
	@Column(name="Modify_by")
	private long modifyby;
	private boolean isDeleted;
	private boolean isActive;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate", nullable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedDate", nullable = false)
    private Date updatedDate;
	
	@OneToMany(mappedBy ="soc",cascade = {CascadeType.PERSIST})
	private List<Tower> tow=new ArrayList<Tower>();
	
	public Society() {
		super();
	}
	
	

	public Society(String societyName, long createdby, boolean isDeleted, boolean isActive) {
		super();
		this.societyName = societyName;
		this.createdby = createdby;
		this.modifyby = createdby;
		this.isDeleted = isDeleted;
		this.isActive = isActive;
		this.createdDate=new Date();
		this.updatedDate=new Date();
	}
	
	
	public Date getCreated() {
		return createdDate;
	}


	public Date getUpdated() {
		return updatedDate;
	}


	public void setUpdated() {
		this.updatedDate = new Date();
	}



	public String getSocietyName() {
		return societyName;
	}
	public void setSocietyName(String societyName) {
		setUpdated();
		this.societyName = societyName;
	}
	public long getSocietyid() {
		return societyid;
	}
	public long getCreatedby() {
		return createdby;
	}

	public long getModifyby() {
		return modifyby;
	}
	public void setModifyby(long modifyby) {
		setUpdated();
		this.modifyby = modifyby;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		setUpdated();
		this.isDeleted = isDeleted;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		setUpdated();
		this.isActive = isActive;
	}
	public List<Tower> getTow() {
		return tow;
	}
	public void setTow(List<Tower> tow) {
		setUpdated();
		this.tow = tow;
	}

}
