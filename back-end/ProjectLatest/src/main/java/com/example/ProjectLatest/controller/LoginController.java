package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.service.LoginService;
import com.example.ProjectLatest.to.FlatResidentTO;
import com.example.ProjectLatest.to.LoginTO;
import com.example.ProjectLatest.to.RestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("/login")
    public void verifyUser(){
        //service.verifyUser(login.getRequestObject(),login.getToken());
        System.out.println("controller");
    }

}
