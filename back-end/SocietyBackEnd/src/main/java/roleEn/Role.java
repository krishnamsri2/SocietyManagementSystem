package roleEn;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import menuEn.MenuSecurity;
import userEn.UserDetails;

@Entity
@Table(name="Role")
public class Role 
{
	private RoleType roleType;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleId;
	
	private String role;
	
	private long createdBy;
	private long modifiedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdDate",nullable=false)
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updatedDate",nullable=false)
	private Date modifyDate;
	
	private Boolean isDeleted;
	private Boolean isActive;
	
	@OneToOne
	@JoinColumn(name="userDetailsID")	// ForeignKey
	private UserDetails userDetails;  
	
	@OneToOne(mappedBy="role")
	private MenuSecurity menuSecurity;
	
	
	
	
	public Role(RoleType roleType, String role, long createdBy,UserDetails userDetails) {
		super();
		this.roleType = roleType;
		this.role = role;
		this.createdBy = createdBy;
		this.modifiedBy = createdBy;
		this.createDate = new Date();
		this.modifyDate = new Date();
		this.isDeleted = false;
		this.isActive = true;
		this.userDetails = userDetails;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		setModifyDate();
		this.roleType = roleType;
	}

	public int getRoleId() {
		return roleId;
	}
	
	
	public String getRole() {
		
		return role;
	}
	
	public void setRole(String role) {
		setModifyDate();
		this.role = role;
	}
	
	
	public UserDetails getUser() {
		
		return userDetails;
	}

	public void setUser(UserDetails user) {
		setModifyDate();
		this.userDetails = user;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	
	public long getModifiedBy() {
		return modifiedBy;
	}
	
	
	public Date getCreateDate() {
		return createDate;
	}
	
	
	public Date getModifyDate() {
		return modifyDate;
	}
	
	public void setModifyDate() {
		this.modifyDate = new Date();
	}
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(Boolean isDeleted) {
		setModifyDate();
		this.isDeleted = isDeleted;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive) {
		setModifyDate();
		this.isActive = isActive;
	}
	
	
}
