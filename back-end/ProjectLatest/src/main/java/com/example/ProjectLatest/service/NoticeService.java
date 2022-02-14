package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.Notice;
import com.example.ProjectLatest.repository.NoticeRepository;
import com.example.ProjectLatest.to.NoticeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    @Autowired
    private NoticeRepository repository;
    //POST
    public Notice saveNotice(NoticeTO notice){
        new Notice(notice.getNoticeDetail());
        return repository.save(notice);
    }

    public List<Notice> saveNotices(List<Notice> notices){
        return repository.saveAll(notices);
    }

    public Notice updateNotice(Notice notice){
        Notice existingNotice=repository.findById(notice.getNoticeId()).orElse(null);
        existingNotice.setNoticeDetail(notice.getNoticeDetail());
        existingNotice.setUserId(notice.getUserId());

        return repository.save(existingNotice);
    }

    //GET
    public List<Notice> getNotices(){
        return repository.findAll();
    }

    public Notice getNoticeById(long id){
        return repository.findById(id).orElse(null);
    }

    public Notice getNoticeByUserId(long userId){
        return repository.findByUserId(userId);
    }

    //DELETE
    public String deleteNotice(long id){
        repository.deleteById(id);
        return "product removed !!" +id;
    }


}
