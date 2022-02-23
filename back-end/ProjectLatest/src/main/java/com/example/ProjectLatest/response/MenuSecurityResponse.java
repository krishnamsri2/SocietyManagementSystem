package com.example.ProjectLatest.response;

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
    }

    public long getRoleId() {
        return roleId;
    }

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
}
