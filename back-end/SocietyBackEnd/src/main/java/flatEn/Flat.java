package flatEn;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import billEn.Bill;
import complaintEn.Complaint;
import flatresidentEn.FlatResidents;

@Entity
public class Flat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long flatid;
	private String flatno;
	private boolean status;
	private int number_of_occupants;
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
	@JoinColumn(name="tower_id")
	private Tower tow2;
	
	@OneToMany(mappedBy = "flat", cascade={CascadeType.PERSIST, CascadeType.REMOVE} )
	private Set<Bill> bills = new HashSet<Bill>();
	
	@OneToMany(mappedBy = "flat1", cascade={CascadeType.PERSIST, CascadeType.REMOVE} )
	private Set<Complaint> complaints = new HashSet<Complaint>();
	
	@OneToMany(mappedBy = "flat", cascade={CascadeType.PERSIST, CascadeType.REMOVE} )
	private Set<FlatResidents> residents = new HashSet<FlatResidents>();
	
	
	// constructor 
	public Flat() {
		super();
	}
	// constructor including all

	public long getFlatid() {
		return flatid;
	}
	public Flat(String flatno, boolean status, int number_of_occupants, long createdby,
			boolean isDeleted, boolean isActive, Tower tow2) {
		super();
		this.flatno = flatno;
		this.status = status;
		this.number_of_occupants = number_of_occupants;
		this.createdby = createdby;
		this.modifyby = createdby;
		this.isDeleted = isDeleted;
		this.isActive = isActive;
		this.created=new Date();
		this.updated=new Date();
		this.tow2 = tow2;
	}
	
	public Date getCreated() {
		return created;
	}


	public void setFlatid(long flatid) {
		this.flatid = flatid;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated() {
		
		this.updated = new Date();
	}
	public String getFlatno() {
		return flatno;
	}
	public void setFlatno(String flatno) {
		setUpdated();
		this.flatno = flatno;
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
		complaint.setFlat1(this);
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
