package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.entity.Notice;
import com.example.ProjectLatest.service.NoticeService;
import com.example.ProjectLatest.to.NoticeTO;
import com.example.ProjectLatest.to.RestRequest;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoticeController {

    @Autowired
    private NoticeService service;
// Important to implement
    @PostMapping("/addNotice")
    public Notice addNotice(@RequestBody RestRequest<NoticeTO> notice){
        return service.saveNotice(notice.getRequestObject());
    }

    @GetMapping("/notices")
    public List<Notice> findAllNotices(){
        return service.getNotices();
    }

    @GetMapping("/notices/{id}")
    public Notice findNoticeById(@PathVariable long id) {
        return service.getNoticeById(id);
    }

    @PutMapping("/update/{id}")
    public Notice updateNotice(@PathVariable long id,@RequestBody RestRequest<NoticeTO> notice){
        return service.updateNotice(id,notice.getRequestObject());
    }

    @DeleteMapping("/delete/{id}")
    public String deleteNotice(@PathVariable long id){
        return service.deleteNotice(id);
    }

}
