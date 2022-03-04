package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.entity.Announcement;
import com.example.ProjectLatest.response.AnnouncementResponse;
import com.example.ProjectLatest.service.AnnouncementService;
import com.example.ProjectLatest.to.AnnouncementTO;
import com.example.ProjectLatest.to.RestRequest;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnnouncementController {

    @Autowired
    private AnnouncementService service;
    // Important to implement
    @PostMapping("/addAnnouncement")
    public void addAnnouncement(@RequestBody RestRequest<AnnouncementTO> announcement){
        service.saveAnnouncement(announcement.getRequestObject());
    }

    @GetMapping("/announcements")
    public List<AnnouncementResponse> findAllAnnouncement(){
        return service.getAnnouncements();
    }

    @GetMapping("/announcements/{id}")
    public AnnouncementResponse findAnnouncementById(@PathVariable long id) {
        return service.getAnnouncementById(id);
    }

    @PutMapping("/updateAnnouncement/{id}")
    public void updateAnnouncement(@PathVariable long id,@RequestBody RestRequest<AnnouncementTO> announcement){
        service.updateAnnouncement(id,announcement.getRequestObject());

    }

    @DeleteMapping("/deleteAnnouncement/{id}")
    public void deleteAnnouncement(@PathVariable long id){

        service.deleteAnnouncement(id);
    }

}
