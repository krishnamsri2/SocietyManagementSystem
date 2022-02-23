package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.entity.Menu;
import com.example.ProjectLatest.response.MenuResponse;
import com.example.ProjectLatest.service.MenuService;
import com.example.ProjectLatest.to.MenuTO;
import com.example.ProjectLatest.to.RestRequest;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class MenuController {

    @Autowired
    private MenuService service;
    // Important to implement
    @PostMapping("/addMenu")
    public void addMenu(@RequestBody RestRequest<MenuTO> menu){
        service.saveMenu(menu.getRequestObject());
    }

    @GetMapping("/menus")
    public List<MenuResponse> findAllMenus(){
        return service.getMenus();
    }

    @GetMapping("/menus/{id}")
    public MenuResponse findMenuById(@PathVariable long id) {
        return service.getMenuById(id);
    }

    @PutMapping("/updateMenu/{id}")
    public MenuResponse updateMenu(@PathVariable long id,@RequestBody RestRequest<MenuTO> menu){
        return service.updateMenu(id,menu.getRequestObject());
    }

    @DeleteMapping("/deleteMenu/{id}")
    public String deleteMenu(@PathVariable long id){
        return service.deleteMenu(id);
    }

}
