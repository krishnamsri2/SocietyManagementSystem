package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.entity.Announcement;
import com.example.ProjectLatest.entity.Complaint;
import com.example.ProjectLatest.response.AnnouncementResponse;
import com.example.ProjectLatest.response.ComplaintHistoryResponse;
import com.example.ProjectLatest.response.ComplaintResponse;
import com.example.ProjectLatest.response.ComplaintWorkerResponse;
import com.example.ProjectLatest.service.AnnouncementService;
import com.example.ProjectLatest.service.ComplaintService;
import com.example.ProjectLatest.to.AnnouncementTO;
import com.example.ProjectLatest.to.ComplaintTO;
import com.example.ProjectLatest.to.RestRequest;
import com.example.ProjectLatest.to.WorkTO;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComplaintController {

    @Autowired
    private ComplaintService service;

    @PostMapping("/addComplaint")
    public void addComplaint(@RequestBody RestRequest<ComplaintTO> complaint)
    {
        service.saveComplaint(complaint.getRequestObject());
        return;
    }

    // GET request for Worker's dashboard
    @GetMapping("/AvailableWorks")
    public List<ComplaintWorkerResponse> getAvailableComplaintsForWorkers()
    {
        return service.getComplaintsForWorkers();
    }
    @PutMapping("/assignAndUpdateWork")
    public void assignAndUpdateWork(@RequestBody RestRequest<WorkTO> workTO)
    {
        service.assignAndUpdateWork(workTO.getRequestObject());
    }

    @GetMapping("/assignedWorks/{userId}")
    public List<ComplaintWorkerResponse> assignedWorkByRoleId(@PathVariable long userId)
    {
        return service.assignedWorks(userId);
    }

    // GET all complaints created by flatId;
    @GetMapping("/myComplaints")
    public List<ComplaintResponse> allComplaintsByFlatId(@RequestBody RestRequest<ComplaintTO> complaintTO)
    {
        return service.allComplaints(complaintTO.getRequestObject());
    }
    @GetMapping("/complaintHistory")
    public List<ComplaintHistoryResponse> getComplaintHistory(@RequestBody RestRequest<ComplaintTO> complaintTO)
    {
        return service.allComplaintHistory(complaintTO.getRequestObject());
    }

    /*
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
     */

}
