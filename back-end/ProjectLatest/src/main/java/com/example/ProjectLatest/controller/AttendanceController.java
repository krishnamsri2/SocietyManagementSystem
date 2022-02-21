package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.response.AttendanceResponse;
import com.example.ProjectLatest.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @PostMapping("/users/{id}/addAttendance")
    public void addAttendance(@PathVariable long id){
         service.saveAttendance(id);
    }

    @GetMapping("/users/attendance/{id}")
    public List<AttendanceResponse> findAttendancesById(@PathVariable long id) {
        return service.getUserAttendances(id);
    }

    @PutMapping("/users/punchOut/{id}")
    public void updateAttendance(@PathVariable long id){
         service.updateAttendance(id);
    }

    @DeleteMapping("/users/delete/attendance/{id}")
    public void deleteUserAttendance(@PathVariable long id){
         service.deleteUserAttendance(id);
    }


}
