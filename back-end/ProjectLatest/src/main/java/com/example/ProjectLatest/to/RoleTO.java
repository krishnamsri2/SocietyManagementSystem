package com.example.ProjectLatest.to;

import com.example.ProjectLatest.entity.RoleType;
import com.example.ProjectLatest.entity.UserDetails;

public class RoleTO
{
    private Long roleId;
    private RoleType roleType;
    private String roleDescription;
    private String role;


    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
