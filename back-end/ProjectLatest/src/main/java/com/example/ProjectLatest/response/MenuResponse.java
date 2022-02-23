package com.example.ProjectLatest.response;

public class MenuResponse {
    private String menuDetail;
    private long  menuId;


    public MenuResponse(String menuDetail, long menuId) {
        this.menuDetail = menuDetail;
        this.menuId = menuId;
    }

    public String getMenuDetail() {
        return menuDetail;
    }

    public void setMenuDetail(String menuDetail) {
        this.menuDetail = menuDetail;
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }
}
