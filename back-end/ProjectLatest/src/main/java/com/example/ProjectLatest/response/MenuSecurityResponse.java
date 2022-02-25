package com.example.ProjectLatest.response;

import java.util.List;

public class MenuSecurityResponse
{
    private long menuId;
    List<RoleResponse> roleResponses;

    public MenuSecurityResponse(long menuId, List<RoleResponse> roleResponses) {
        this.menuId = menuId;
        this.roleResponses = roleResponses;
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public List<RoleResponse> getRoleResponses() {
        return roleResponses;
    }

    public void setRoleResponses(List<RoleResponse> roleResponses) {
        this.roleResponses = roleResponses;
    }
}
