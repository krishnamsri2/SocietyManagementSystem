//package com.example.ProjectLatest.controller;
//
//import com.example.ProjectLatest.response.LoginResponse;
//import com.example.ProjectLatest.service.LoginService;
//import com.example.ProjectLatest.to.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import static com.example.ProjectLatest.Security.Interceptor.hashMemory;
//
//@RestController
//public class LoginController {
//
//    @Autowired
//    private LoginService service;
//
//    @PostMapping("/login/{examplemailId}")
//    public LoginResponse verifyUser(@PathVariable String emailId){
//        return service.createToken(emailId);
//    }
//
//    @GetMapping("/logout")
//    public void logoutUser(){
//        //return "User Logout Successful";
//    }
//
//}
