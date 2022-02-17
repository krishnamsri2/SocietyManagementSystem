package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.response.AttendanceResponse;
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
    public String addUser(@RequestBody RestRequest<UserTO> user){
         return service.saveUser(user.getRequestObject(),user.getToken());
    }

    @PostMapping("/users/{id}/addAttendance")
    public String addAttendance(@PathVariable long id){
        return service.saveAttendance(id);
    }

    @GetMapping("/users/{id}")
    public UserDetailsResponse findUserById(@PathVariable long id) {
        return service.getUserById(id);
    }

    @GetMapping("/users/attendance/{id}")
    public List<AttendanceResponse> findAttendancesById(@PathVariable long id) {
        return service.getUserAttendances(id);
    }

    @PutMapping("/users/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody RestRequest<UserTO> user){
         return service.updateUser(id,user.getRequestObject(),user.getToken());

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



}
