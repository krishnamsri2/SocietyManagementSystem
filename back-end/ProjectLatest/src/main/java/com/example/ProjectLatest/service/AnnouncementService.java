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
    public AnnouncementResponse saveAnnouncement(AnnouncementTO announcement) {
        AnnouncementResponse announcementResponse = null;
        try {
            Announcement tempAnnouncement = new Announcement(announcement.getAnnouncementTitle(),announcement.getAnnouncementDetail(), 76);
            announcementResponse = new AnnouncementResponse(tempAnnouncement.getAnnouncementTitle(),tempAnnouncement.getAnnouncementDetail(), tempAnnouncement.getannoucementId());
            repository.save(tempAnnouncement);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return announcementResponse;
    }

    //PUT
    public AnnouncementResponse updateAnnouncement(long id,AnnouncementTO announcement) {
        AnnouncementResponse announcementResponse = null;
        try {
            Announcement existingAnnouncement = repository.findById(id).orElse(null);
            existingAnnouncement.setAnnouncementTitle(announcement.getAnnouncementTitle());
            existingAnnouncement.setAnnouncementDetail(announcement.getAnnouncementDetail());
            announcementResponse = new AnnouncementResponse(existingAnnouncement.getAnnouncementTitle(),existingAnnouncement.getAnnouncementDetail(), existingAnnouncement.getannoucementId());
            repository.save(existingAnnouncement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return announcementResponse;
    }

    //GET
    public List<AnnouncementResponse> getAnnouncements() {
        List<AnnouncementResponse> responseList = null;
        try {
            responseList = new ArrayList<>();
            List<Announcement> announcementList = repository.findAll();
            for (Announcement announcement : announcementList) {
                responseList.add(new AnnouncementResponse(announcement.getAnnouncementTitle(),announcement.getAnnouncementDetail(), announcement.getannoucementId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseList;

    }

    public AnnouncementResponse getAnnouncementById(long id) {

        AnnouncementResponse announcementResponse = null;
        try {
            Announcement existingAnnouncement = repository.findById(id).orElse(null);
            announcementResponse = new AnnouncementResponse(existingAnnouncement.getAnnouncementTitle(),existingAnnouncement.getAnnouncementDetail(), existingAnnouncement.getannoucementId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return announcementResponse;
    }

    //DELETE
    public String deleteAnnouncement(long id){
        try {
            Announcement announcement = repository.findById(id).orElse(null);
            if (announcement != null) {
                announcement.setIsDeleted(true);

                return "Product removed !!" + id;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return " No Announceemnt found with this !!" + id;
    }


}
