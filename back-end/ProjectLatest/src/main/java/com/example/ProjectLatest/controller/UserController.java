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

    @PutMapping("/users/punchOut/{id}")
    public String updateAttendance(@PathVariable long id){
        return service.updateAttendance(id);
    }


    @DeleteMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable long id){
        return service.deleteUser(id);
    }

    @DeleteMapping("/users/delete/attendance/{id}")
    public String deleteUserAttendance(@PathVariable long id){
        return service.deleteUserAttendance(id);
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