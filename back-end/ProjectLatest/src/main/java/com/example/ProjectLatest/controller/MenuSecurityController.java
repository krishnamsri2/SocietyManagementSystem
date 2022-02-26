package com.example.ProjectLatest.controller;



import com.example.ProjectLatest.response.RoleWithStatusResponse;
import com.example.ProjectLatest.service.MenuSecurityService;
import com.example.ProjectLatest.to.MenuSecurityTO;
import com.example.ProjectLatest.to.RestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //GET Role Status
    @RequestMapping(method = RequestMethod.GET,value = "/status/{id}")
    public List<RoleWithStatusResponse> getRolesStatuses(@PathVariable Long id)
    {
        return service.getRolesStatuses(id);
    }

    //Unassign Role to a menu
    @RequestMapping(method = RequestMethod.PUT,value="/unassignMenu")
    public void unassignMenu(@RequestBody RestRequest<MenuSecurityTO> menuSecurityTORestRequest)
    {
        service.unassignMenu(menuSecurityTORestRequest.getRequestObject());
    }
}
