package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.response.AttendanceResponse;
import com.example.ProjectLatest.service.AttendanceService;
import com.example.ProjectLatest.to.AttendanceTO;
import com.example.ProjectLatest.to.FlatResidentTO;
import com.example.ProjectLatest.to.RestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @PostMapping("/users/addAttendance")
    public void addAttendance(@RequestBody RestRequest<AttendanceTO> attendance){
         service.saveAttendance(attendance.getRequestObject());
    }

    @GetMapping("/users/attendance/{id}")
    public List<AttendanceResponse> findAttendancesById(@PathVariable long id) {
        return service.getUserAttendances(id);
    }

    @PutMapping("/users/punchOut")
    public void updateAttendance(@RequestBody RestRequest<AttendanceTO> attendance){
         service.updateAttendance(attendance.getRequestObject());
    }

    @DeleteMapping("/users/delete/attendance/{id}")
    public void deleteUserAttendance(@PathVariable long id){
         service.deleteUserAttendance(id);
    }


}
