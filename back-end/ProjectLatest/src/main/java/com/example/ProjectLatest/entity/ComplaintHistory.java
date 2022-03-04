package com.example.ProjectLatest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ComplaintHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cmpHisId;
    private String type; // Plumber , Electrician , carpenter
	@Enumerated(EnumType.STRING)
    private ComplaintStatus complaintStatus; // 0 =filed , 1 =inprogress , 2 =solved
    private Long userId;

    @ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="complaintId")
	@JsonBackReference
    private Complaint complaint;
    
    private String createdBy;
    private String modifyBy;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate", nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedDate", nullable = false)
    private Date updated;

    
    private Boolean isActive;
    private Boolean isDeleted;

    public ComplaintHistory() {
    }

    public ComplaintHistory(String type,ComplaintStatus complaintStatus, String createdBy,Complaint complaint) {
        this.type = type;
        this.complaintStatus = complaintStatus;
        this.updated = new Date();
        this.created = new Date();
        this.createdBy = createdBy;
        this.modifyBy = createdBy;
        this.isActive = true;
        this.isDeleted = false;
		this.complaint = complaint;
    }

	public Long getCmpHisId() {
		return cmpHisId;
	}

	public String getType() {
		return type;
	}

	public ComplaintStatus getStatus() {
		return complaintStatus;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		setUpdated();
		this.userId = userId;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		setUpdated();
		this.complaint = complaint;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
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
    
    
}



