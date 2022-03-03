package com.example.ProjectLatest.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Flat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="flatId")
	private long flatId;
	@Column(name = "flatNo")
	private String flatNo;
	@Column(name="status")
	private boolean status;
	private int number_of_occupants;
	@Column(name = "createdBy")
	private long createdBy;
	@Column(name="modifyBy")
	private long modifyBy;
	@Column(name="isDeleted")
	private boolean isDeleted;
	@Column(name="isActive")
	private boolean isActive;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate", nullable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedDate", nullable = false)
    private Date updatedDate;
    
	@ManyToOne
	@JoinColumn(name="tower_id")
	private Tower tow2;
	
	@OneToMany(mappedBy = "flat")
	private Set<Bill> bills = new HashSet<Bill>();
	
	@OneToMany(mappedBy = "flat")
	private Set<Complaint> complaints = new HashSet<Complaint>();
	
	@OneToMany(mappedBy = "flat" )
	private Set<FlatResidents> residents = new HashSet<FlatResidents>();
	
	
	// constructor 
	public Flat() {
		super();
	}
	// constructor including all

	public long getFlatId() {
		return flatId;
	}
	public Flat(String flatNo, boolean status, int number_of_occupants, long createdBy,
			boolean isDeleted, boolean isActive, Tower tow2) {
		super();
		this.flatNo = flatNo;
		this.status = status;
		this.number_of_occupants = number_of_occupants;
		this.createdBy = createdBy;
		this.modifyBy = createdBy;
		this.isDeleted = isDeleted;
		this.isActive = isActive;
		this.createdDate=new Date();
		this.updatedDate=new Date();
		this.tow2 = tow2;
	}
	
	public Date getCreated() {
		return createdDate;
	}


	public void setFlatId(long flatId) {
		this.flatId = flatId;
	}

	public Date getUpdated() {
		return updatedDate;
	}

	public void setUpdated() {
		
		this.updatedDate = new Date();
	}
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		setUpdated();
		this.flatNo = flatNo;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		setUpdated();
		this.status = status;
	}
	public int getNumber_of_occupants() {
		return number_of_occupants;
	}
	public void setNumber_of_occupants(int number_of_occupants) {
		setUpdated();
		this.number_of_occupants = number_of_occupants;
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
	public Tower getTow2() {
		return tow2;
	}
	public void setTow2(Tower tow2) {
		setUpdated();
		this.tow2 = tow2;
	}

	public Set<Bill> getBill() {
		return bills;
	}

	public void addBill(Bill bill) {
		setUpdated();
		bills.add(bill);
    	bill.setFlat(this);
	}

	public Set<Complaint> getComplaints() {
		return complaints;
	}
	
	public void addComplaint(Complaint complaint) {
		setUpdated();
		complaints.add(complaint);
		complaint.setFlat(this);
	}
	
	public Set<FlatResidents> getFlatResidents() {
		return residents;
	}
	
	public void addFlatResidents(FlatResidents resident) {
		setUpdated();
		residents.add(resident);
		resident.setFlat(this);
	}
	
	
	
}
