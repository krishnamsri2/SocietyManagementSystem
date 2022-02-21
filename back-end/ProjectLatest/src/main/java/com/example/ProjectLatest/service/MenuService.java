package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.Announcement;
import com.example.ProjectLatest.entity.Menu;
import com.example.ProjectLatest.repository.MenuRepository;
import com.example.ProjectLatest.response.AnnouncementResponse;
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

    public MenuResponse saveMenu(MenuTO menu){


        Menu tempMenu = new Menu(menu.getUrl(), 765);
        MenuResponse menuResponse = new MenuResponse(tempMenu.getUrl(),tempMenu.getMenuId());
       repository.save(tempMenu);
        return menuResponse;

    }
    //PUT
    public MenuResponse updateMenu(long id,MenuTO menu){
        Menu existingMenu=repository.findById(id).orElse(null);
        existingMenu.setUrl(menu.getUrl());
        MenuResponse menuResponse = new MenuResponse(existingMenu.getUrl(),existingMenu.getMenuId());
         repository.save(existingMenu);
         return menuResponse;
    }

    //GET
    public List<MenuResponse> getMenus(){
        List<MenuResponse> responseList = new ArrayList<>();
        List<Menu> menuList =   repository.findAll();
        for(Menu menu: menuList){
            responseList.add(new MenuResponse(menu.getUrl(), menu.getMenuId()));
        }
        return responseList;
    }

    public MenuResponse getMenuById(long id){
        Menu existingMenu = repository.findById(id).orElse(null);
        MenuResponse menuResponse = new MenuResponse(existingMenu.getUrl(), existingMenu.getMenuId());
        return menuResponse;
    }

    //DELETE
    public String deleteMenu(long id){
        Menu menu = repository.findById(id).orElse(null);
        if(menu!=null){
            menu.setIsDeleted(true);

            return "product removed !!" +id;
        }
        return " No menu found with this !!" +id;
    }


}
