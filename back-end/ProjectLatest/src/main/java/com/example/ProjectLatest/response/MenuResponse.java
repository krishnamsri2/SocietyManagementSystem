package com.example.ProjectLatest.response;

public class MenuResponse {
    private String url;
    private long  menuId;
    private String menuName;

    public MenuResponse(String url, long menuId, String menuName) {
        this.url = url;
        this.menuId = menuId;
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
