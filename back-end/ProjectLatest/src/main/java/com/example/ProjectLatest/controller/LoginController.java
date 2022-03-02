package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.response.LoginResponse;
import com.example.ProjectLatest.service.LoginService;
import com.example.ProjectLatest.to.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.ProjectLatest.Security.Interceptor.hashMemory;

@RestController
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("/login")
    public LoginResponse verifyUser(@RequestBody RestRequest<LoginTO> login){
        User user = service.verifyUser(login.getRequestObject());
        return service.createToken(login.getRequestObject().getEmailId());
    }

    @GetMapping("/logout")
    public void logoutUser(@RequestBody RestRequest<LoginTO> login){
        service.deleteToken(login.getRequestObject().getUserId());
    }

}
