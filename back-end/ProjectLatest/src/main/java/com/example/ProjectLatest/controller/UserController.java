package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.entity.Attendance;
import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.entity.UserDetails;
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
    // Important to implement
    @PostMapping("/users/addUser")
    public void addUser(@RequestBody RestRequest<UserTO> user){
         service.saveUser(user.getRequestObject(),user.getToken());
    }

    @PostMapping("/users/{id}/addAttendance")
    public void addAttendance(@PathVariable long id){
        service.saveAttendance(id);
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
    public void updateUser(@PathVariable long id, @RequestBody RestRequest<UserTO> user){
         service.updateUser(id,user.getRequestObject(),user.getToken());
         service.getUserById(id);
    }

    @PutMapping("/users/punchOut/{id}")
    public void updateAttendance(@PathVariable long id){
        service.updateAttendance(id);
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
