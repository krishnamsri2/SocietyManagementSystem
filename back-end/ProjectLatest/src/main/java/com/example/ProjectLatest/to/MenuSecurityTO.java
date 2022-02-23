package com.example.ProjectLatest.to;

import com.example.ProjectLatest.entity.Menu;
import com.example.ProjectLatest.entity.Role;

public class MenuSecurityTO {

    private Role role;
    private Menu menu;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



    public Menu getMenu() {
        return menu;
    }
    public void setMenu(Menu menu) {

        this.menu = menu;
    }

//    public long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(long userId) {
//        this.userId = userId;
//    }
}
