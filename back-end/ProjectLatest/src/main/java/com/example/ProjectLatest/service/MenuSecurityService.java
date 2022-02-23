package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.MenuSecurity;
import com.example.ProjectLatest.repository.MenuRepository;
import com.example.ProjectLatest.repository.MenuSecurityRepository;
import com.example.ProjectLatest.repository.RoleRepository;
import com.example.ProjectLatest.response.MenuSecurityResponse;
import com.example.ProjectLatest.response.RoleResponse;
import com.example.ProjectLatest.to.MenuSecurityTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuSecurityService {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<MenuSecurityResponse> getMenuList(MenuSecurityTO menuSecurity)
    {
        long userDetailsId = menuSecurity.getUserDetailsId();
        long roleId = menuSecurity.getRoleId();

        List<MenuSecurityResponse> menus = new ArrayList<MenuSecurityResponse>();

        return menus;

    }
    /*@Autowired
    private MenuSecurityRepository repository;

    /POST

    public MenuSecurity saveMenuSecurity(MenuSecurityTO menuSecurity){


        MenuSecurity tempMenuSecurity = new MenuSecurity(menuSecurity.getRole(), menuSecurity.getMenu(), 76);
        return repository.save(tempMenuSecurity);

    }
    //PUT
    public MenuSecurity updateMenuSecurity(long id,MenuSecurityTO menuSecurity){
        MenuSecurity existingMenuSecurity=repository.findById(id).orElse(null);
        existingMenuSecurity.setRole(menuSecurity.getRole());
        existingMenuSecurity.setMenu(menuSecurity.getMenu());


        return repository.save(existingMenuSecurity);
    }

    //GET
    public List<MenuSecurity> getMenuSecurities(){
        return repository.findAll();
    }

    public MenuSecurity getMenuSecurityById(long id){
        return repository.findById(id).orElse(null);
    }

    //DELETE
    public String deleteMenuSecurity(long id){
        repository.deleteById(id);
        return "product removed !!" +id;
    }*/



}
