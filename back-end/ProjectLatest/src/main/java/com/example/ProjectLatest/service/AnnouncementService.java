package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.Announcement;
import com.example.ProjectLatest.repository.AnnouncementRepository;
import com.example.ProjectLatest.response.AnnouncementResponse;
import com.example.ProjectLatest.to.AnnouncementTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementRepository repository;
    //POST
    public AnnouncementResponse saveAnnouncement(AnnouncementTO announcement){

        Announcement tempAnnouncement = new Announcement(announcement.getAnnouncementDetail(), 76);
        AnnouncementResponse announcementResponse = new AnnouncementResponse(tempAnnouncement.getAnnouncementDetail(), tempAnnouncement.getannoucementId());
         repository.save(tempAnnouncement);
         return announcementResponse;

    }

    //PUT
    public AnnouncementResponse updateAnnouncement(long id,AnnouncementTO announcement){
        Announcement existingAnnouncement=repository.findById(id).orElse(null);

        existingAnnouncement.setAnnouncementDetail(announcement.getAnnouncementDetail());
        AnnouncementResponse announcementResponse = new AnnouncementResponse(existingAnnouncement.getAnnouncementDetail(), existingAnnouncement.getannoucementId());
        repository.save(existingAnnouncement);
        return announcementResponse;
    }

    //GET
    public List<AnnouncementResponse> getAnnouncements(){
        List<AnnouncementResponse> responseList = new ArrayList<>();
        List<Announcement> announcementList =   repository.findAll();
        for(Announcement announcement: announcementList){
            responseList.add(new AnnouncementResponse(announcement.getAnnouncementDetail(), announcement.getannoucementId()));
        }
        return responseList;

    }

    public AnnouncementResponse getAnnouncementById(long id){
        Announcement existingAnnouncement = repository.findById(id).orElse(null);
        AnnouncementResponse announcementResponse = new AnnouncementResponse(existingAnnouncement.getAnnouncementDetail(), existingAnnouncement.getannoucementId());
        return announcementResponse;
    }

    //DELETE
    public String deleteAnnouncement(long id){
        Announcement announcement = repository.findById(id).orElse(null);
        if(announcement!=null){
            announcement.setIsDeleted(true);

            return "Product removed !!" +id;
        }
        return " No Announceemnt found with this !!" +id;
    }


}
