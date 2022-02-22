package com.example.ProjectLatest.response;

import com.example.ProjectLatest.entity.RoleType;

public class RoleResponse
{
    private RoleType roleType;
    private String role;
    private String roleDescription;

    public RoleResponse()
    {

    }
    public RoleResponse(RoleType roleType, String role, String roleDescription)
    {
        this.roleType = roleType;
        this.role = role;
        this.roleDescription = roleDescription;
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
