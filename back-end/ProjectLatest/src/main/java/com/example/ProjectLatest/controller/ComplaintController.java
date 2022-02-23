package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.entity.Announcement;
import com.example.ProjectLatest.response.AnnouncementResponse;
import com.example.ProjectLatest.response.ComplaintResponse;
import com.example.ProjectLatest.service.AnnouncementService;
import com.example.ProjectLatest.service.ComplaintService;
import com.example.ProjectLatest.to.AnnouncementTO;
import com.example.ProjectLatest.to.ComplaintTO;
import com.example.ProjectLatest.to.RestRequest;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComplaintController {

    @Autowired
    private ComplaintService service;
    // Important to implement
    @PostMapping("/addComplaint")
    public ComplaintResponse addComplaint(@RequestBody RestRequest<ComplaintTO> complaint){
        return service.saveComplaint(complaint.getRequestObject());
    }

    @GetMapping("/complaints")
    public List<ComplaintResponse> findAllComplaint(){
        return service.getComplaints();
    }

    @GetMapping("/complaints/{id}")
    public ComplaintResponse findComplaintById(@PathVariable long id) {
        return service.getComplaintById(id);
    }

    @PutMapping("/updateComplaint/{id}")
    public ComplaintResponse updateComplaint(@PathVariable long id,@RequestBody RestRequest<ComplaintTO> complaint){
        return service.updateComplaint(id,complaint.getRequestObject());

    }

    @DeleteMapping("/deleteComplaint/{id}")
    public String deleteComplaint(@PathVariable long id){

        return service.deleteComplaint(id);
    }

}
