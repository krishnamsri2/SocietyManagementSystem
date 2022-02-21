package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.entity.Role;
import com.example.ProjectLatest.response.RoleResponse;
import com.example.ProjectLatest.service.RoleService;
import com.example.ProjectLatest.to.RestRequest;
import com.example.ProjectLatest.to.RoleTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
public class RoleController
{
    @Autowired
    private RoleService roleService;

    @RequestMapping(method = RequestMethod.POST, value = "/userDetails/{id}/role")
    public void addRole(@RequestBody RestRequest<RoleTO> role, @PathVariable Long id)
    {
        roleService.addRole(role.getRequestObject(),id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/role/{id}")
    public Set<RoleResponse> getRoleByUserDetailsId(@PathVariable Long id)
    {
        return roleService.findRolesByUserDetailsId(id);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/role/{id}")
    public void updateRoleByRoleId(@RequestBody RestRequest<RoleTO> role, @PathVariable Long id)
    {
        roleService.updateRoleByRoleId(role.getRequestObject(),id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/role/{id}")
    public void deleteRoleByRoleId(@PathVariable Long id)
    {
        roleService.deleteRoleByRoleId(id);
    }



}
