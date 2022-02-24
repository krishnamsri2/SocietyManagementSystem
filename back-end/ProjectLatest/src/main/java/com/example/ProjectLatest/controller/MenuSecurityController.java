package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.response.MenuResponse;
import com.example.ProjectLatest.response.MenuSecurityResponse;
import com.example.ProjectLatest.service.MenuSecurityService;
import com.example.ProjectLatest.service.MenuService;
import com.example.ProjectLatest.to.MenuSecurityTO;
import com.example.ProjectLatest.to.MenuTO;
import com.example.ProjectLatest.to.RestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuSecurityController
{
    @Autowired
    private MenuSecurityService service;

    //POST
    @PostMapping("/assignMenu")
    public MenuSecurityResponse assignMenu(@RequestBody RestRequest<MenuSecurityTO> menuSecurity){
        return service.assignMenu(menuSecurity.getRequestObject());
    }

    @GetMapping("/assignedMenus")
    public MenuSecurityResponse getAssignedMenusByRoleId(@RequestBody RestRequest<MenuSecurityTO> menuSecurity)
    {
        return service.getAssignedMenusByRoleId(menuSecurity.getRequestObject());
    }
}
