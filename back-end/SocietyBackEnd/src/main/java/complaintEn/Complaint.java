package complaintEn;

import javax.persistence.*;

import flatEn.Flat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long complaintId;
    private String type; // Plumber , Electrician , carpenter
    private int status; // 0 =filed , 1 =inprogress , 2 =solved
    private Long userId;

    //private Flat flatId; for foreignkey relationship
    
    @OneToMany(mappedBy = "complaint", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<ComplaintHistory> complaintHistories = new HashSet<ComplaintHistory>();
    
    @ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="FlatId")
	private Flat flat1;

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

    public Complaint() {
    }

    public Complaint(String type, Long createdBy) {
        this.type = type;
        this.status = 0;
        this.updated = new Date();
        this.created = new Date();
        this.createdBy = createdBy;
        this.modifyBy = createdBy;
        this.isActive = true;
        this.isDeleted = false;
        this.userId = null;
    }

	public Long getComplaintId() {
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

	public void addComplaintHistory(ComplaintHistory complaintHistory ) {
		setUpdated();
    	complaintHistories.add(complaintHistory);
    	complaintHistory.setComplaint(this);
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

	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
    	setUpdated();
        this.status = status;
        
        if(status == 2)
        	setIsActive(false);
    }

	public Flat getFlat1() {
		return flat1;
	}

	public void setFlat1(Flat flat1) {
		this.flat1 = flat1;
	}
	
	

}


