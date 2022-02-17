package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.entity.Notice;
import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.service.NoticeService;
import com.example.ProjectLatest.service.UserService;
import com.example.ProjectLatest.to.NoticeTO;
import com.example.ProjectLatest.to.RestRequest;
import com.example.ProjectLatest.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private UserService service;
    // Important to implement
    @PostMapping("/addUser")
    public void addUser(@RequestBody RestRequest<UserTO> userTO){
         service.saveUser(userTO.getRequestObject());
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return service.getUsers();
    }


}
