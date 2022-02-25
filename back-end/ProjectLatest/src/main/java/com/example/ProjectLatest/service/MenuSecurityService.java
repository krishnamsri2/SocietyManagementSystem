package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.Menu;
import com.example.ProjectLatest.entity.MenuSecurity;
import com.example.ProjectLatest.entity.Role;
import com.example.ProjectLatest.repository.MenuSecurityRepository;
import com.example.ProjectLatest.repository.RoleRepository;
import com.example.ProjectLatest.response.MenuResponse;
import com.example.ProjectLatest.response.MenuSecurityResponse;
import com.example.ProjectLatest.response.RoleResponse;
import com.example.ProjectLatest.to.MenuSecurityTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuSecurityService {

    @Autowired
    private MenuSecurityRepository menuSecurityRepository;
    @Autowired
    private RoleRepository roleRepository;

    public void assignMenu(MenuSecurityTO menuSecurityTO)
    {
        long menuId = menuSecurityTO.getMenuId();
        long roleId = menuSecurityTO.getRoleId();
        Role role = roleRepository.getById(roleId);
        if(role.getIsMenuAssigned()==false) {
            MenuSecurity menuSecurity = new MenuSecurity(menuId, roleId);
            menuSecurityRepository.save(menuSecurity);
            role.setIsMenuAssigned(true);
            roleRepository.save(role);
        }


    }

    public MenuSecurityResponse getAllRolesAssigned(MenuSecurityTO menuSecurityTO)
    {
        long menuId = menuSecurityTO.getMenuId();

        List<MenuSecurity> menuSecurities = menuSecurityRepository.findAllByMenuId(menuId);
        List<Role> roles = new ArrayList<Role>();

        for(MenuSecurity menuSecurity:menuSecurities)
        {
            long roleId = menuSecurity.getRoleId();
            Role role = roleRepository.getById(roleId);
            if(role.getIsMenuAssigned())
                roles.add(role);
        }

        List<RoleResponse> roleResponses = roles.stream()
                .map(Role -> new RoleResponse(Role.getRoleId(),Role.getRoleType(),Role.getRole(),Role.getRoleDescription(),Role.getIsActive(),Role.getIsMenuAssigned()))
                .collect(Collectors.toList());

        MenuSecurityResponse MenuSecurityResponse = new MenuSecurityResponse(menuId,roleResponses);

        return MenuSecurityResponse;

    }

    public void deassignMenu(MenuSecurityTO menuSecurityTO)
    {
        long menuId = menuSecurityTO.getMenuId();
        long roleId = menuSecurityTO.getRoleId();
        Role role = roleRepository.getById(roleId);
        role.setIsMenuAssigned(false);
        roleRepository.save(role);
        MenuSecurity menuSecurity = menuSecurityRepository.getByMenuIdRoleId(menuId,roleId);
        menuSecurityRepository.delete(menuSecurity);
    }
}
