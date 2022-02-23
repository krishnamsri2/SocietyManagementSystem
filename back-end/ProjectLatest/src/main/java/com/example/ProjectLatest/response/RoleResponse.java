package com.example.ProjectLatest.response;

import com.example.ProjectLatest.entity.RoleType;

public class RoleResponse
{
    private Long roleId;
    private RoleType roleType;
    private String role;
    private String roleDescription;
    private Boolean isActive;
    private Boolean isDeleted;


    public RoleResponse()
    {

    }
    public RoleResponse(Long roleId,RoleType roleType, String role, String roleDescription,Boolean isActive,Boolean isDeleted)
    {
        this.roleType = roleType;
        this.role = role;
        this.roleDescription = roleDescription;
        this.roleId = roleId;
        this.isActive=isActive;
        this.isDeleted=isDeleted;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Long getRoleId() {
        return roleId;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
