package com.example.ProjectLatest.response;

import com.example.ProjectLatest.entity.RoleType;

public class RoleWithStatusResponse
{
    private long roleId;
    private RoleType roleType;
    private String role;
    private String roleDescription;


    private boolean status;

    public RoleWithStatusResponse(long roleId, RoleType roleType, String role, String roleDescription,boolean status) {
        this.roleId = roleId;
        this.roleType = roleType;
        this.role = role;
        this.roleDescription = roleDescription;
        this.status = status;
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
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
