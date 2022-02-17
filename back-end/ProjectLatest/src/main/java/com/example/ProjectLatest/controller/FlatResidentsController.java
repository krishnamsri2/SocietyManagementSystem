package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.entity.FlatResidents;
import com.example.ProjectLatest.response.AttendanceResponse;
import com.example.ProjectLatest.response.FlatResidentResponse;
import com.example.ProjectLatest.response.UserDetailsResponse;
import com.example.ProjectLatest.service.FlatResidentsService;
import com.example.ProjectLatest.service.UserService;
import com.example.ProjectLatest.to.FlatResidentTO;
import com.example.ProjectLatest.to.RestRequest;
import com.example.ProjectLatest.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlatResidentsController {
    @Autowired
    private FlatResidentsService service;

    @PostMapping("/flatResidents/addFlatResidents")
    public void addFlatResident(@RequestBody RestRequest<FlatResidentTO> user){
        service.saveFlatResident(user.getRequestObject(),user.getToken());
    }

    @GetMapping("/flatResidents/{id}")
    public FlatResidentResponse findFlatResidentById(@PathVariable long id) {
        return service.getFlatResidentById(id);
    }

    @GetMapping("/flatResidents/{flatId}")
    public List<FlatResidentResponse> findFlatResidentsByFlatId(@PathVariable long flatId){
        return service.getFlatResidentsByFlatId(flatId);
    }

    @GetMapping("/flatResidents/{userdetailId}")
    public List<FlatResidentResponse> findFlatResidentsByUserDetailId(@PathVariable long userDetailId){
        return service.getFlatResidentsByUserDetailId(userDetailId);
    }

    @PutMapping("/flatResidents/update/{id}")
    public void updateFlatResident(@PathVariable long id, @RequestBody RestRequest<FlatResidentTO> user){
        service.updateFlatResident(id,user.getRequestObject(),user.getToken());
    }

    @DeleteMapping("/flatResidents/delete/{id}")
    public String deleteFlatResident(@PathVariable long id){
        return service.deleteFlatResident(id);
    }

}
