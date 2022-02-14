package com.example.ProjectLatest.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
public class Tower {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long towerid;
	private String towername;
	private long createdby;
	private long modifyby;
	private boolean isDeleted;
	private boolean isActive;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate", nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedDate", nullable = false)
    private Date updated;
    
	@ManyToOne(cascade = {CascadeType.PERSIST})
	private Society soc;
	@OneToMany(mappedBy ="tow2",cascade = {CascadeType.PERSIST})
	private List<Flat> flat=new ArrayList<Flat>();
	
	public Tower() {
		super();
	}
	
	public Tower(String towername, long createdby,boolean isDeleted, boolean isActive, Society soc) {
		super();
		this.towername = towername;
		this.createdby = createdby;
		this.modifyby = createdby;
		this.isDeleted = isDeleted;
		this.isActive = isActive;
		this.soc = soc;
		this.created=new Date();
		this.updated=new Date();
	}
	
	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated() {
		
		this.updated = new Date();
	}

	public long getTowerid() {
		return towerid;
	}
	public String getTowername() {
		return towername;
	}
	public void setTowername(String towername) {
		setUpdated();
		this.towername = towername;
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
	public Society getSoc() {
		return soc;
	}
	public void setSoc(Society soc) {
		setUpdated();
		this.soc = soc;
	}
	public List<Flat> getFlat() {
		return flat;
	}
	public void setFlat(List<Flat> flat) {
		setUpdated();
		this.flat = flat;
	}
	
}
