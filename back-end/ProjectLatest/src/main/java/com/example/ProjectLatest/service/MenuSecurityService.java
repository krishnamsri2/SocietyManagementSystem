package com.example.ProjectLatest.service;

<<<<<<< HEAD
import com.example.ProjectLatest.entity.MenuSecurity;
import com.example.ProjectLatest.repository.MenuRepository;
import com.example.ProjectLatest.repository.MenuSecurityRepository;
import com.example.ProjectLatest.repository.RoleRepository;
import com.example.ProjectLatest.response.MenuSecurityResponse;
import com.example.ProjectLatest.response.RoleResponse;
=======
import com.example.ProjectLatest.entity.Menu;
import com.example.ProjectLatest.entity.Role;
import com.example.ProjectLatest.repository.MenuRepository;
import com.example.ProjectLatest.repository.RoleRepository;
import com.example.ProjectLatest.response.MenuResponse;
import com.example.ProjectLatest.response.MenuSecurityResponse;
>>>>>>> 2d17a4c1b374e9febbda54c5abdcc254b56e488e
import com.example.ProjectLatest.to.MenuSecurityTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
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



=======
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
>>>>>>> 2d17a4c1b374e9febbda54c5abdcc254b56e488e
}
