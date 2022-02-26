package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.response.LoginResponse;
import com.example.ProjectLatest.service.LoginService;
import com.example.ProjectLatest.to.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.ProjectLatest.Security.Interceptor.hashMemory;


@RestController
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("/login/{emailId}")
    public LoginResponse verifyUser(@PathVariable String emailId){
        return service.createToken(emailId);
    }

}
