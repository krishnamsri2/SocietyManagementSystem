package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.entity.UserDetails;
import com.example.ProjectLatest.service.UserDetailsService;
import com.example.ProjectLatest.service.UserService;
import com.example.ProjectLatest.to.RestRequest;
import com.example.ProjectLatest.to.UserDetailsTO;
import com.example.ProjectLatest.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserDetailsController
{
    @Autowired
    private UserDetailsService service;
    // Important to implement
    @PostMapping("/user/{id}/addDetails")
    public void addUserDetails(@RequestBody RestRequest<UserDetailsTO> userDetailsTO, @PathVariable Long id){
        service.saveUserDetails(userDetailsTO.getRequestObject(),id);
    }

    @GetMapping("/user/{id}/userDetails")
    public List<UserDetails> findAllUsers(){
        return service.getUserDetails();
    }

}
