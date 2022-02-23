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
    @RequestMapping(method = RequestMethod.GET, value = "/roles/{id}")
    public Set<RoleResponse> getRoleByUserDetailsId(@PathVariable Long id)
    {
        return roleService.findRolesByUserDetailsId(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/role/{id}")
    public RoleResponse getRoleByRoleId(@PathVariable Long id)
<<<<<<< HEAD
    {
        return roleService.findRoleByRoleId(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/role/{id}")
    public void updateRoleByRoleId(@RequestBody RestRequest<RoleTO> role, @PathVariable Long id)
    {
        roleService.updateRoleByRoleId(role.getRequestObject(),id);
=======
    {
        return roleService.findRoleByRoleId(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/role/{id}")
    public void updateRoleByRoleId(@RequestBody RestRequest<RoleTO> role, @PathVariable Long id)
    {
        roleService.updateRoleByRoleId(role.getRequestObject(),id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/role/activate/{id}")
    public void activateRoleStatus(@RequestBody RestRequest<RoleTO> role,@PathVariable Long id)
    {
        roleService.activateRoleByRoleId(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "role/deactivate/{id}")
    public void deactivateRoleStatus(@RequestBody RestRequest<RoleTO> role,@PathVariable Long id)
    {
        roleService.deactivateRoleByRoleId(id);
>>>>>>> 6b816359d0104da0ba74f438b7e1778ff0a99757
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/role/{id}")
    public void deleteRoleByRoleId(@PathVariable Long id)
    {
        roleService.deleteRoleByRoleId(id);
    }



}
