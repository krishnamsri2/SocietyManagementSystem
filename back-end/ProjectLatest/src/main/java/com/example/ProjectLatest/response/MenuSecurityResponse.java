package com.example.ProjectLatest.response;

import java.util.List;

public class MenuSecurityResponse
{
    private long menuId;
    private String menuName;
    private String menuUrl;

    public MenuSecurityResponse(long menuId, String menuName, String menuUrl) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
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

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
