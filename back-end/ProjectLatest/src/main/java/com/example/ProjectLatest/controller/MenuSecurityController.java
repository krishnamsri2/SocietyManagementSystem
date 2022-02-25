package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.entity.MenuSecurity;
import com.example.ProjectLatest.response.MenuSecurityResponse;
import com.example.ProjectLatest.service.MenuSecurityService;
import com.example.ProjectLatest.to.MenuSecurityTO;
import com.example.ProjectLatest.to.RestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuSecurityController
{
    @Autowired
    private MenuSecurityService service;

    //POST
    @RequestMapping(method = RequestMethod.POST,value = "/assignMenu")
    public void assignMenu(@RequestBody RestRequest<MenuSecurityTO> menuSecurityTORestRequest)
    {
        service.assignMenu(menuSecurityTORestRequest.getRequestObject());
    }

    //GET
    @RequestMapping(method = RequestMethod.GET,value="/AssignedRoles")
    public MenuSecurityResponse assignedRoles(@RequestBody RestRequest<MenuSecurityTO> menuSecurityTORestRequest)
    {
        return service.getAllRolesAssigned(menuSecurityTORestRequest.getRequestObject());
    }

    //SOFT Delete
    @RequestMapping(method = RequestMethod.PUT,value="/DeassignMenu")
    public void deassignMenu(@RequestBody RestRequest<MenuSecurityTO> menuSecurityTORestRequest)
    {
        service.deassignMenu(menuSecurityTORestRequest.getRequestObject());
    }
}
