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

            Notice tempNotice = new Notice(notice.getNoticeDetail(), 112L, notice.getUserId());
            return repository.save(tempNotice);


    }
   //PUT
    public Notice updateNotice(long id,NoticeTO notice){
        Notice existingNotice=repository.findById(id).orElse(null);
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

    //DELETE
    public String deleteNotice(long id){
        repository.deleteById(id);
        return "product removed !!" +id;
    }


}
