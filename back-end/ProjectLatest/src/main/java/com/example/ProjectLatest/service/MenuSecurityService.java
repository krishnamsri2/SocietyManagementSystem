package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.Menu;
import com.example.ProjectLatest.entity.MenuSecurity;
import com.example.ProjectLatest.entity.Role;
import com.example.ProjectLatest.repository.MenuRepository;
import com.example.ProjectLatest.repository.MenuSecurityRepository;
import com.example.ProjectLatest.repository.RoleRepository;
import com.example.ProjectLatest.response.*;
import com.example.ProjectLatest.to.MenuSecurityTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MenuSecurityService {

    @Autowired
    private MenuSecurityRepository menuSecurityRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MenuRepository menuRepository;


    public void assignMenu(MenuSecurityTO menuSecurityTO)
    {
        MenuSecurity menuSecurity;
        try {
            long menuId = menuSecurityTO.getMenuId();
            long roleId = menuSecurityTO.getRoleId();
            if (menuSecurityRepository.getByMenuIdRoleId(menuId, roleId) == null)
            {
                menuSecurity = new MenuSecurity(menuId, roleId);
                menuSecurityRepository.save(menuSecurity);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return;
    }
    public List<RoleWithStatusResponse> getRolesStatuses(Long menuId)
    {
        List<RoleWithStatusResponse> responses= new ArrayList<RoleWithStatusResponse>();;
        try {
            List<Long> unassigendRoleIds = menuSecurityRepository.getAllUnassigned(menuId);
            List<Long> assignedRoleIds = menuSecurityRepository.getAllAssigned(menuId);
            for (Long roleId : unassigendRoleIds) {
                Role role = roleRepository.getById(roleId);
                RoleWithStatusResponse response = new RoleWithStatusResponse(role.getRoleId(), role.getRoleType(), role.getRole(), false);
                responses.add(response);
            }
            for (Long roleId : assignedRoleIds) {
                Role role = roleRepository.getById(roleId);
                RoleWithStatusResponse response = new RoleWithStatusResponse(role.getRoleId(), role.getRoleType(), role.getRole(), true);
                responses.add(response);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return responses;
    }

    public List<MenuSecurityResponse> getMenuByUserId(MenuSecurityTO menuSecurityTO)
    {
        List<MenuSecurityResponse> menuSecurityResponses = new ArrayList<MenuSecurityResponse>();
        try {
            Set<Long> menuIdsAssigned = menuSecurityRepository.findByUserId(menuSecurityTO.getUserId());
            for (Long Id : menuIdsAssigned) {
                Menu menu = menuRepository.getById(Id);
                MenuSecurityResponse menuSecurityResponse = new MenuSecurityResponse(menu.getMenuId(), menu.getMenuName(), menu.getUrl());
                menuSecurityResponses.add(menuSecurityResponse);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return menuSecurityResponses;
    }

    public void unassignMenu(MenuSecurityTO menuSecurityTO)
    {
        try {
            long menuId = menuSecurityTO.getMenuId();
            long roleId = menuSecurityTO.getRoleId();
            MenuSecurity menuSecurity = menuSecurityRepository.getByMenuIdRoleId(menuId, roleId);
            menuSecurityRepository.delete(menuSecurity);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return;
    }
}
