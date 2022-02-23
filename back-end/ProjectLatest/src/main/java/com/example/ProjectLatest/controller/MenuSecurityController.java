package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.entity.MenuSecurity;
import com.example.ProjectLatest.service.MenuSecurityService;
import com.example.ProjectLatest.to.MenuSecurityTO;
import com.example.ProjectLatest.to.RestRequest;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuSecurityController {

    @Autowired
    private MenuSecurityService service;
    // Important to implement
    @PostMapping("/addMenuSecurity")
    public MenuSecurity addMenuSecurity(@RequestBody RestRequest<MenuSecurityTO> menuSecurity){
        return service.saveMenuSecurity(menuSecurity.getRequestObject());
    }

    @GetMapping("/menuSecurities")
    public List<MenuSecurity> findAllMenuSecurities(){
        return service.getMenuSecurities();
    }

    @GetMapping("/menuSecurities/{id}")
    public MenuSecurity findMenuSecurityById(@PathVariable long id) {
        return service.getMenuSecurityById(id);
    }

    @PutMapping("/updateMenuSecurity/{id}")
    public MenuSecurity updateMenuSecurity(@PathVariable long id,@RequestBody RestRequest<MenuSecurityTO> menuSecurity){
        return service.updateMenuSecurity(id,menuSecurity.getRequestObject());
    }

    @DeleteMapping("/deleteMenuSecurity/{id}")
    public String deleteMenuSecurity(@PathVariable long id){
        return service.deleteMenuSecurity(id);
    }

}
