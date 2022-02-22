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

    @PostMapping("/users/flatResidents/addFlatResidents")
    public void addFlatResident(@RequestBody RestRequest<FlatResidentTO> user){
        service.saveFlatResident(user.getRequestObject(),user.getToken());
    }

    @GetMapping("/users/flatResidents/{id}")
    public FlatResidentResponse findFlatResidentById(@PathVariable long id) {
        return service.getFlatResidentById(id);
    }

    @GetMapping("/flat/{flatId}/flatResidents")
    public List<FlatResidentResponse> findFlatResidentsByFlatId(@PathVariable long flatId){
        return service.getFlatResidentsByFlatId(flatId);
    }

    @GetMapping("/users/{userDetailId}/flatResidents")
    public List<FlatResidentResponse> findFlatResidentsByUserDetailId(@PathVariable long userDetailId){
        return service.getFlatResidentsByUserDetailId(userDetailId);
    }

    @PutMapping("users/flatResidents/update/{id}")
    public void updateFlatResident(@PathVariable long id, @RequestBody RestRequest<FlatResidentTO> user){
        service.updateFlatResident(id,user.getRequestObject(),user.getToken());
    }

    @DeleteMapping("users/flatResidents/delete/{id}")
    public void deleteFlatResident(@PathVariable long id){
         service.deleteFlatResident(id);
    }

}
