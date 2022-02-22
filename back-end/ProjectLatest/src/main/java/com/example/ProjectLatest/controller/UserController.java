package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.response.UserDetailsResponse;
import com.example.ProjectLatest.service.UserService;
import com.example.ProjectLatest.to.RestRequest;
import com.example.ProjectLatest.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/users/addUser")
    public void addUser(@RequestBody RestRequest<UserTO> user){
          service.saveUser(user.getRequestObject(),user.getToken());
    }

    @GetMapping("/users/{id}")
    public UserDetailsResponse findUserById(@PathVariable long id) {
        return service.getUserById(id);
    }

    @GetMapping("/users")
    public List<UserDetailsResponse> findAllUser() {
        return service.getAllUser();
    }


    @PutMapping("/users/update/{id}")
    public void updateUser(@PathVariable long id, @RequestBody RestRequest<UserTO> user){
          service.updateUser(id,user.getRequestObject(),user.getToken());

    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable long id){
         service.deleteUser(id);
    }

}