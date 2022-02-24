package com.example.ProjectLatest.response;

import com.example.ProjectLatest.entity.Menu;

import java.util.List;
import java.util.Set;

public class MenuSecurityResponse
{
    private long roleId;
    List<MenuResponse> menuList;


    public MenuSecurityResponse(long roleId, List<MenuResponse> menuList) {
        this.roleId = roleId;
        this.menuList = menuList;
    }

    public long getRoleId() {
        return roleId;
    }


    public List<MenuResponse> getMenuList() {
        return menuList;
    }


}
