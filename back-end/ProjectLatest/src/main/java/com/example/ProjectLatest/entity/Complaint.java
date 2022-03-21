package com.example.ProjectLatest.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long complaintId;
    private String type; // Plumber , Electrician , carpenter
	@Enumerated(EnumType.STRING)
    private ComplaintStatus complaintStatus; // 0 =filed , 1 =inprogress , 2 =solved
    private Long userId;

	private String complaintDetails;
    //private Flat flatId; for foreignkey relationship
    
    @OneToMany(mappedBy = "complaint", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonManagedReference
    private Set<ComplaintHistory> complaintHistories = new HashSet<ComplaintHistory>();
    
    @ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="FlatId")
	private Flat flat;

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

    public Complaint() {
    }

    public Complaint(String type,ComplaintStatus complaintStatus,String complaintDetails, String createdBy) {
        this.type = type;
        this.complaintStatus = complaintStatus;
		this.complaintDetails = complaintDetails;
        this.updated = new Date();
        this.created = new Date();
        this.createdBy = createdBy;
        this.modifyBy = createdBy;
        this.isActive = true;
        this.isDeleted = false;
        //this.userId = null;
    }

	public long getComplaintId() {
		return complaintId;
	}

	public String getType() {
		return type;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		setUpdated();
		this.userId = userId;
	}

	public Set<ComplaintHistory> getComplaintHistories() {
		return complaintHistories;
	}

//	public void addComplaintHistory(ComplaintHistory complaintHistory ) {
//		setUpdated();
//    	complaintHistories.add(complaintHistory);
//    	complaintHistory.setComplaint(this);
//	}

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

	public ComplaintStatus getComplaintStatus() {
		return complaintStatus;
	}
	
	public void setStatus(ComplaintStatus complaintStatus) {
    	setUpdated();
        this.complaintStatus = complaintStatus;

    }

	public Flat getFlat() {
		return flat;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}




	public void setType(String type) {
		this.type=type;
	}

	public String getComplaintDetails() {
		return complaintDetails;
	}

	public void setComplaintDetails(String complaintDetails) {
		this.complaintDetails = complaintDetails;
	}
}


