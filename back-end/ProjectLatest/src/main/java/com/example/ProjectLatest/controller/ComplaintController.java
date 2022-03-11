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
    public List<ComplaintWorkerResponse> assignedWorkByUserId(@PathVariable long userId)
    {
        return service.assignedWorks(userId);
    }
    @GetMapping("/completedWorks/{workerId}")
    public List<ComplaintWorkerResponse> completedWorks(@PathVariable long workerId)
    {
        return service.getCompletedWorks(workerId);
    }

    // GET all complaints created by flatId;
    @GetMapping("/myComplaints")
    public List<ComplaintResponse> allComplaintsByFlatId(@RequestBody RestRequest<ComplaintTO> complaintTO)
    {
        return service.allComplaints(complaintTO.getRequestObject());
    }
    @GetMapping("/complaintHistory/{id}")
    public List<ComplaintHistoryResponse> getComplaintHistory(@PathVariable long id)
    {
        return service.allComplaintHistory(id);
    }


}
