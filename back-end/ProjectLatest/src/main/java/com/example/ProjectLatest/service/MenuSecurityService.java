package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.Menu;
import com.example.ProjectLatest.entity.MenuSecurity;
import com.example.ProjectLatest.entity.Role;
import com.example.ProjectLatest.entity.RoleType;
import com.example.ProjectLatest.repository.MenuRepository;
import com.example.ProjectLatest.repository.MenuSecurityRepository;
import com.example.ProjectLatest.repository.RoleRepository;
import com.example.ProjectLatest.response.*;
import com.example.ProjectLatest.to.MenuSecurityTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuSecurityService {

    @Autowired
    private MenuSecurityRepository menuSecurityRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MenuRepository menuRepository;
    private SessionFactory sessionFactory;

    public void assignMenu(MenuSecurityTO menuSecurityTO)
    {
        long menuId = menuSecurityTO.getMenuId();
        long roleId = menuSecurityTO.getRoleId();
        MenuSecurity menuSecurity;
        if(menuSecurityRepository.getByMenuIdRoleId(menuId,roleId)==null)
        {
            menuSecurity = new MenuSecurity(menuId, roleId);
            menuSecurityRepository.save(menuSecurity);
        }

    }
    public List<RoleWithStatusResponse> getRolesStatuses(Long menuId)
    {
        List<Long> unassigendRoleIds = menuSecurityRepository.getAllUnassigned(menuId);
        List<Long> assignedRoleIds = menuSecurityRepository.getAllAssigned(menuId);
        List<RoleWithStatusResponse> responses = new ArrayList<RoleWithStatusResponse>();
        for(Long roleId:unassigendRoleIds)
        {
            Role role = roleRepository.getById(roleId);
            RoleWithStatusResponse response = new RoleWithStatusResponse(role.getRoleId(),role.getRoleType(),role.getRole(),false);
            responses.add(response);
        }
        for(Long roleId:assignedRoleIds)
        {
            Role role = roleRepository.getById(roleId);
            RoleWithStatusResponse response = new RoleWithStatusResponse(role.getRoleId(),role.getRoleType(),role.getRole(),true);
            responses.add(response);
        }
        return responses;
    }

    public List<MenuSecurityResponse> getMenuByUserId(MenuSecurityTO menuSecurityTO)
    {

        Set<Long> menuIdsAssigned = menuSecurityRepository.findByUserId(menuSecurityTO.getUserId());

        List<MenuSecurityResponse> menuSecurityResponses = new ArrayList<MenuSecurityResponse>();

        for(Long Id:menuIdsAssigned)
        {
            Menu menu = menuRepository.getById(Id);
            MenuSecurityResponse menuSecurityResponse = new MenuSecurityResponse(menu.getMenuId(),menu.getMenuName(),menu.getUrl());
            menuSecurityResponses.add(menuSecurityResponse);
        }

        return menuSecurityResponses;
    }

    public void unassignMenu(MenuSecurityTO menuSecurityTO)
    {
        long menuId = menuSecurityTO.getMenuId();
        long roleId = menuSecurityTO.getRoleId();
        MenuSecurity menuSecurity = menuSecurityRepository.getByMenuIdRoleId(menuId,roleId);
        menuSecurityRepository.delete(menuSecurity);
    }
}
