package com.example.ProjectLatest.response;

import java.util.List;

public class MenuSecurityStatusResponse
{
    private long menuId;
    private List<RoleWithStatusResponse> roleWithStatusResponseList;

    public MenuSecurityStatusResponse(long menuId, List<RoleWithStatusResponse> roleWithStatusResponseList) {
        this.menuId = menuId;
        this.roleWithStatusResponseList = roleWithStatusResponseList;
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public List<RoleWithStatusResponse> getRoleWithStatusResponseList() {
        return roleWithStatusResponseList;
    }

    public void setRoleWithStatusResponseList(List<RoleWithStatusResponse> roleWithStatusResponseList) {
        this.roleWithStatusResponseList = roleWithStatusResponseList;
    }
}
