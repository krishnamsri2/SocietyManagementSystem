package com.example.ProjectLatest.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class FlatResidents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long flatResId;
	private boolean isOwner;
	private boolean isTenant;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="FlatId")
	private Flat flat;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="userDetailId")
	private UserDetails userDetail;
	
	@OneToMany(mappedBy = "flatResidents", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Announcement> announcements = new HashSet<Announcement>();
	
	
	private Long createdBy;
    private Long modifyBy;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate", nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedDate", nullable = false)
    private Date updated;

    
    private Boolean isActive;
    private Boolean isDeleted;

	public FlatResidents() {
	}

	public FlatResidents(Boolean isOwner, Boolean isTenant, long createdBy, Flat flat, UserDetails usd ) {
    	this.flat = flat;
    	this.userDetail = usd;
        this.isOwner = isOwner;
        this.isTenant = isTenant;
        this.updated = new Date();
        this.created = new Date();
        this.createdBy = createdBy;
        this.modifyBy = createdBy;
        this.isActive = true;
        this.isDeleted = false;
    }

	public long getFlatResId() {
		return flatResId;
	}

	public boolean isOwner() {
		return isOwner;
	}

	public void setOwner(boolean isOwner) {
		setUpdated();
		this.isOwner = isOwner;
	}

	public boolean isTenant() {
		return isTenant;
	}

	public void setTenant(boolean isTenant) {
		setUpdated();
		this.isTenant = isTenant;
	}

	public Long getCreatedBy() {
		return createdBy;
	}


	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		setUpdated();
		this.modifyBy = modifyBy;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		setUpdated();
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		setUpdated();
		this.isDeleted = isDeleted;
	}

	public Set<Announcement> getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(Set<Announcement> announcements) {
		this.announcements = announcements;
	}
    
	public void addAnnouncements(Announcement announcement ) {
		setUpdated();
		announcements.add(announcement);
		announcement.setFlatResidents(this);
	}

	public Flat getFlat() {
		return flat;
	}

	public void setFlat(Flat flat) {
		setUpdated();
		this.flat = flat;
	}

	public UserDetails getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetails userDetail) {
		setUpdated();
		this.userDetail = userDetail;
	}
	
	

	
}
