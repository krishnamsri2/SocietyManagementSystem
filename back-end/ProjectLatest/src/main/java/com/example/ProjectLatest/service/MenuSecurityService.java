package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.Menu;
import com.example.ProjectLatest.entity.Role;
import com.example.ProjectLatest.repository.MenuRepository;
import com.example.ProjectLatest.repository.RoleRepository;
import com.example.ProjectLatest.response.MenuResponse;
import com.example.ProjectLatest.response.MenuSecurityResponse;
import com.example.ProjectLatest.to.MenuSecurityTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MenuSecurityService
{
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MenuRepository menuRepository;

    public MenuSecurityResponse assignMenu(MenuSecurityTO menuSecurity)
    {

        long roleId = menuSecurity.getRoleId();
        long menuId = menuSecurity.getMenuId();

        Role role = roleRepository.getById(roleId);
        Menu menu = menuRepository.getById(menuId);

        role.getMenus().add(menu);
        menu.getRoles().add(role);

        roleRepository.save(role);
        menuRepository.save(menu);



        List<Menu> temp = role.getMenus();
        List<MenuResponse> copy = temp.stream()
        .map(Menu -> new MenuResponse(Menu.getUrl(),Menu.getMenuId(),Menu.getMenuName()))
        .collect(Collectors.toList());

        MenuSecurityResponse response = new MenuSecurityResponse(roleId,copy);

        return response;
    }

    public MenuSecurityResponse getAssignedMenusByRoleId(MenuSecurityTO menuSecurity)
    {
        long roleId = menuSecurity.getRoleId();
        Role role = roleRepository.getById(roleId);

        List<Menu> menuList = role.getMenus();

        List<MenuResponse> menuResponseList = menuList.stream()
                .map(Menu -> new MenuResponse(Menu.getUrl(),Menu.getMenuId(),Menu.getMenuName()))
                .collect(Collectors.toList());

        MenuSecurityResponse menuResponse = new MenuSecurityResponse(roleId,menuResponseList);

        return menuResponse;


    }
}
