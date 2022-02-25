package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.Menu;
import com.example.ProjectLatest.repository.MenuRepository;
import com.example.ProjectLatest.response.MenuResponse;
import com.example.ProjectLatest.to.MenuTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository repository;

    //POST

    public MenuResponse saveMenu(MenuTO menu) {
        MenuResponse menuResponse = null;
        try {
            Menu tempMenu = new Menu(menu.getUrl(), 765, menu.getMenuName());
            menuResponse = new MenuResponse(tempMenu.getUrl(), tempMenu.getMenuId(), tempMenu.getMenuName());
            repository.save(tempMenu);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return menuResponse;

    }
    //PUT
    public MenuResponse updateMenu(long id,MenuTO menu) {
        MenuResponse menuResponse = null;
        try {
            Menu existingMenu = repository.findById(id).orElse(null);
            existingMenu.setUrl(menu.getUrl());
            existingMenu.setMenuName(menu.getMenuName());
            menuResponse = new MenuResponse(existingMenu.getUrl(), existingMenu.getMenuId(), existingMenu.getMenuName());
            repository.save(existingMenu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuResponse;
    }

    //GET
    public List<MenuResponse> getMenus() {
        List<MenuResponse> responseList = null;
        try {
            responseList = new ArrayList<>();
            List<Menu> menuList = repository.findAll();
            for (Menu menu : menuList) {
                responseList.add(new MenuResponse(menu.getUrl(), menu.getMenuId(), menu.getMenuName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseList;
    }

    public MenuResponse getMenuById(long id) {
        MenuResponse menuResponse = null;
        try {
            Menu existingMenu = repository.findById(id).orElse(null);
            menuResponse = new MenuResponse(existingMenu.getUrl(), existingMenu.getMenuId(), existingMenu.getMenuName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuResponse;
    }

    //DELETE
    public String deleteMenu(long id){
        try {
            Menu menu = repository.findById(id).orElse(null);
            if (menu != null) {
                menu.setIsDeleted(true);

                return "product removed !!" + id;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return " No menu found with this !!" +id;
    }


}
