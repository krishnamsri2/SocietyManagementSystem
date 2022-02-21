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
    public String addAttendance(@PathVariable long id){
        return service.saveAttendance(id);
    }

    @GetMapping("/users/attendance/{id}")
    public List<AttendanceResponse> findAttendancesById(@PathVariable long id) {
        return service.getUserAttendances(id);
    }

    @PutMapping("/users/punchOut/{id}")
    public String updateAttendance(@PathVariable long id){
        return service.updateAttendance(id);
    }

    @DeleteMapping("/users/delete/attendance/{id}")
    public String deleteUserAttendance(@PathVariable long id){
        return service.deleteUserAttendance(id);
    }


}
