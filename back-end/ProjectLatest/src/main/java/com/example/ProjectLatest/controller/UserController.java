package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.response.UserDetailsResponse;
import com.example.ProjectLatest.service.UserService;
import com.example.ProjectLatest.to.RestRequest;
import com.example.ProjectLatest.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;

//    @PostMapping("/users/addUser")
//    public void addUser(@RequestBody RestRequest<UserTO> user){
//          service.saveUser(user.getRequestObject(),user.getToken());
//    }
//
//    @GetMapping("/users/{id}")
//    public UserDetailsResponse findUserById(@PathVariable long id) {
//        return service.getUserById(id);
//    }
//
//    @GetMapping("/users")
//    public List<UserDetailsResponse> findAllUser() {
//        return service.getAllUser();
//    }

    @PostMapping("/users/addUser/admin")
    public void addUserAdmin(@RequestBody RestRequest<UserTO> user){
        service.saveUserAdmin(user.getRequestObject(),user.getToken());
    }

    @PostMapping("/users/addUser")
    public void addUser(@RequestBody RestRequest<UserTO> user){
        service.saveUser(user.getRequestObject(),user.getToken());
    }

    @GetMapping("/users/{userId}")
    public List<UserDetailsResponse> findAllUserAdmin(@PathVariable long userId) {
        return service.getAllUser(userId);
    }


    @PutMapping("/users/update")
    public void updateUser(@RequestBody RestRequest<UserTO> user){
          service.updateUser(user.getRequestObject(),user.getToken());

    }


    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable long id){
         service.deleteUser(id);
    }

}