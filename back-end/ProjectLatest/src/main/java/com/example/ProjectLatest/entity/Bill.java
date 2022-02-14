package com.example.ProjectLatest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billId;
    private String type; // Water , Electricity , Maintainence Bills
    private Long amount;
    private Boolean status; // Paid or Unpaid

    private Long createdBy;
    private Long modifyBy;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate", nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedDate", nullable = false)
    private Date updated;
    
    @ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="FlatId")
	private Flat flat;

    
    private Boolean isActive;
    private Boolean isDeleted;

    public Bill() {
    }

    public Bill(String type, Long createdBy, Long amount) {
        this.type = type;
        this.amount = amount;
        this.status = false;
        this.updated = new Date();
        this.created = new Date();
        this.createdBy = createdBy;
        this.modifyBy = createdBy;
        this.isActive = true;
        this.isDeleted = false;
    }

    public void setDeleted(Boolean deleted) {
    	onUpdate();
        isDeleted = deleted;
    }
    
    public Boolean getDeleted() {
        return isDeleted;
    }

    public String getType() {
        return type;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public Date getCreated() {
        return created;
    }
    
    public void onUpdate() {
        updated = new Date();
    }
    
    public Date getUpdated() {
        return updated;
    }
    
    public Long getBillId() {
        return billId;
    }

    public void setAmount(Long amount) {
    	onUpdate();
        this.amount = amount;
    }
    
    public Long getAmount() {
        return amount;
    }

    public void setStatus(Boolean status) {
    	onUpdate();
        this.status = status;
    }
    
    public Boolean getStatus() {
        return status;
    }

    public void setModifyBy(Long modifyBy) {
    	onUpdate();
        this.modifyBy = modifyBy;
    }
    
    public Long getModifyBy() {
        return modifyBy;
    }

    public void setActive(Boolean active) {
    	onUpdate();
        isActive = active;
    }
    
    public Boolean getActive() {
        return isActive;
    }

	public Flat getFlat() {
		return flat;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}


    
    
    
}

