package com.example.ProjectLatest.response;

import com.example.ProjectLatest.entity.RoleType;

public class RoleResponse {
    private long roleId;
    private RoleType roleType;
    private String role;
    private String roleDescription;
    private Boolean isActive;
    private Boolean isMenuAssigned;


    public RoleResponse(long roleId, RoleType roleType, String role, String roleDescription, Boolean isActive) {
        this.roleId = roleId;
        this.roleType = roleType;
        this.role = role;
        this.roleDescription = roleDescription;
        this.isActive = isActive;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
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


    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean activeRole) {
        this.isActive = isActive;
    }

    public Boolean getMenuAssigned() {
        return isMenuAssigned;
    }

    public void setMenuAssigned(Boolean menuAssigned) {
        isMenuAssigned = menuAssigned;
    }
}
