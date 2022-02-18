package com.example.ProjectLatest.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name="Tower")
public class Tower {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tower_id")
	private long towerId;
	@Column(name="tower_name")
	private String towerName;
	@Column(name="created_by")
	private long createdBy;
	@Column(name="modify_by")
	private long modifyBy;
	@Column(name="is_deleted")
	private boolean isDeleted;
	@Column(name="is_active")
	private boolean isActive;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate", nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedDate", nullable = false)
    private Date updated;
    
	@ManyToOne
	@JoinColumn(name="societyId")
	private Society soc;
	@OneToMany(mappedBy ="tow2",cascade = {CascadeType.PERSIST})
	private List<Flat> flat=new ArrayList<Flat>();
	
	public Tower() {
		super();
	}
	
	public Tower(String towerName, long createdBy,boolean isDeleted, boolean isActive, Society soc) {
		super();
		this.towerName = towerName;
		this.createdBy = createdBy;
		this.modifyBy = createdBy;
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

	public long getTowerId() {
		return towerId;
	}
	public String getTowerName() {
		return towerName;
	}
	public void setTowerName(String towerName) {
		setUpdated();
		this.towerName = towerName;
	}
	public long getCreatedBy() {
		return createdBy;
	}

	public long getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(long modifyBy) {
		setUpdated();
		this.modifyBy = modifyBy;
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
