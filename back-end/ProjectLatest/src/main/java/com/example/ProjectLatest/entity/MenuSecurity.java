package com.example.ProjectLatest.entity;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "MenuSecurity")
public class MenuSecurity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long menuSecurityId;
    private long menuId;
    private long roleId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createdDate",nullable=false)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updatedDate",nullable=false)
    private Date modifyDate;
    private Boolean isDeleted;
    private Boolean isActive;
    public MenuSecurity()
    {

    }

    public MenuSecurity(long menuId, long roleId) {
        this.menuId = menuId;
        this.roleId = roleId;
        this.createDate = new Date();
        this.modifyDate = new Date();
        this.isDeleted = false;
        this.isActive = true;
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

}