package complaintEn;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ComplaintHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cmpHisId;
    private String type; // Plumber , Electrician , carpenter
    private int status; // 0 =filed , 1 =inprogress , 2 =solved
    private Long userId;

    @ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="complaintId")
    private Complaint complaint;
    
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

    public ComplaintHistory() {
    }

    public ComplaintHistory(String type,int status, Long createdBy) {
        this.type = type;
        this.status = status;
        this.updated = new Date();
        this.created = new Date();
        this.createdBy = createdBy;
        this.modifyBy = createdBy;
        this.isActive = true;
        this.isDeleted = false;
    }

	public Long getCmpHisId() {
		return cmpHisId;
	}

	public String getType() {
		return type;
	}

	public int getStatus() {
		return status;
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
    
    
}



