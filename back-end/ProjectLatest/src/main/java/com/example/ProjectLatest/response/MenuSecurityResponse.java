package com.example.ProjectLatest.response;

<<<<<<< HEAD
public class MenuSecurityResponse
{
    private long roleId;
    private long menuId;
    private String menuName;
    private String url;

    public MenuSecurityResponse(long roleId, long menuId, String menuName, String url) {
        this.roleId = roleId;
        this.menuId = menuId;
        this.menuName = menuName;
        this.url = url;
=======
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
>>>>>>> 2d17a4c1b374e9febbda54c5abdcc254b56e488e
    }

    public long getRoleId() {
        return roleId;
    }

<<<<<<< HEAD
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
=======

    public List<MenuResponse> getMenuList() {
        return menuList;
    }


>>>>>>> 2d17a4c1b374e9febbda54c5abdcc254b56e488e
}
