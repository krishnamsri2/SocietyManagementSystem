package userEn;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="User")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	private String password;
	private Boolean status; // Active or Inactive
	
	private Long createdBy;
	private Long modifiedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdDate",nullable=false)
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updatedDate",nullable=false)
	private Date updated;
	
	private Boolean isDeleted;
	private Boolean isActive;
	
	@OneToOne(mappedBy="user")
	private UserDetails usd;
	
	public UserDetails getUsd() {
		return usd;
	}
	
	
	
	public User() {
		
	}

	public User(String password,long createdBy) {
		super();
		this.password = password;
		this.status = false;
		this.createdBy = createdBy;
		this.modifiedBy = createdBy;
		this.created = new Date();
		this.updated = new Date();
		this.isDeleted = false;
		this.isActive = true;
	}

	public long getUserId() {
		return userId;
	}
	

	
	public String getPassword() {
		
		return password;
	}
	
	public void setPassword(String password,long modifiedBy) {
		setUpdated();
		setModifiedBy(modifiedBy);
		this.password = password;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status,long modifiedBy) {
		setUpdated();
		setModifiedBy(modifiedBy);
		this.status = status;
	}
	
	public long getCreatedBy() {
		return createdBy;
	}
	
	
	
	public long getModifiedBy() {
		return modifiedBy;
	}
	
	public void setModifiedBy(long modifyBy) {
		setUpdated() ;
		this.modifiedBy = modifyBy;
	}
	
	public Date getCreatedDate() {
		return created;
	}
	
	
	
	public Date getUpdated() {
		return updated;
	}
	
	public void setUpdated() {
		this.updated = new Date();
	}
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(Boolean isDeleted) {
		setUpdated();
		setModifiedBy(modifiedBy);
		this.isDeleted = isDeleted;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive,long modifiedBy) {
		setUpdated();
		setModifiedBy(modifiedBy);
		this.isActive = isActive;
	}
	
	

}
