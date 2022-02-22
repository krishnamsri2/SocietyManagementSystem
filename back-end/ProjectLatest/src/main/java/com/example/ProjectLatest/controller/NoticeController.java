package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.entity.Notice;
import com.example.ProjectLatest.response.NoticeResponse;
import com.example.ProjectLatest.service.NoticeService;
import com.example.ProjectLatest.to.NoticeTO;
import com.example.ProjectLatest.to.RestRequest;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class  NoticeController {

    @Autowired
    private NoticeService service;

    @PostMapping("/addNotice")
    public void addNotice(@RequestBody RestRequest<NoticeTO> notice){
        service.saveNotice(notice.getRequestObject(),notice.getToken());
    }

    @GetMapping("/notices")
    public List<NoticeResponse> findAllNotices(){
        return service.getNotices();
    }

    @GetMapping("/notices/{id}")
    public NoticeResponse findNoticeById(@PathVariable long id) {
        return service.getNoticeById(id);
    }

    @PutMapping("/update/{id}")
    public void updateNotice(@PathVariable long id,@RequestBody RestRequest<NoticeTO> notice){
         service.updateNotice(id,notice.getRequestObject());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNotice(@PathVariable long id){
         service.deleteNotice(id);
    }

}
