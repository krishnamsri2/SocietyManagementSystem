package com.example.ProjectLatest.service;

import com.example.ProjectLatest.builder.FlatResidentResBuilder;
import com.example.ProjectLatest.builder.NoticeResBuilder;
import com.example.ProjectLatest.entity.Notice;
import com.example.ProjectLatest.repository.NoticeRepository;
import com.example.ProjectLatest.response.NoticeResponse;
import com.example.ProjectLatest.to.NoticeTO;
import com.example.ProjectLatest.to.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoticeService {
    @Autowired
    private NoticeRepository repository;
    //POST
    public void saveNotice(NoticeTO notice, Token token){
        try {
            Notice tempNotice = new Notice(notice.getNoticeTitle(), notice.getNoticeDetail(), token.getUserId());
            repository.save(tempNotice);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
   //PUT
    public void updateNotice(long id,NoticeTO notice){
        try {
            Notice existingNotice = repository.findById(id).orElse(null);

            if(existingNotice.isDeleted() == false && existingNotice != null) {
                existingNotice.setNoticeTitle(notice.getNoticeTitle());
                existingNotice.setNoticeDetail(notice.getNoticeDetail());
                repository.save(existingNotice);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //GET
    public List<NoticeResponse> getNoticesByAdmin(){
        List<NoticeResponse> copy = null;
        try {
            List<Notice> tempNotices = repository.findAll();

             copy = tempNotices.stream()
                    .map(Notice -> new NoticeResBuilder()
                            .setNoticeId(Notice.getNoticeId())
                            .setNoticeTitle(Notice.getNoticeTitle())
                            .setNoticeDetail(Notice.getNoticeDetail())
                            .setCreatedBy(Notice.getCreatedBy())
                            .setCreatedDate(Notice.getCreatedDate())
                            .setUpdatedDate(Notice.getUpdatedDate())
                            .setIsDeleted(Notice.isDeleted())
                            .getResponse())
                    .collect(Collectors.toList());
        }catch (Exception e){
            e.printStackTrace();
        }

        return copy;
    }

    public List<NoticeResponse> getNotices(){
        List<NoticeResponse> copy = null;
        try {
            List<Notice> tempNotices = repository.findAllActive();

            copy = tempNotices.stream()
                    .map(Notice -> new NoticeResBuilder()
                            .setNoticeId(Notice.getNoticeId())
                            .setNoticeTitle(Notice.getNoticeTitle())
                            .setNoticeDetail(Notice.getNoticeDetail())
                            .setCreatedBy(Notice.getCreatedBy())
                            .setCreatedDate(Notice.getCreatedDate())
                            .setUpdatedDate(Notice.getUpdatedDate())
                            .setIsDeleted(Notice.isDeleted())
                            .getResponse())
                    .collect(Collectors.toList());
        }catch (Exception e){
            e.printStackTrace();
        }

        return copy;
    }

    //DELETE
    public void deleteNotice(long id){
        try {
            Notice tempNotice = repository.findById(id).orElse(null);

            if(tempNotice != null){
                if(tempNotice.isDeleted() == false) {
                    tempNotice.setDeleted(true);
                    tempNotice.setActive(false);
                }else{
                    tempNotice.setDeleted(false);
                    tempNotice.setActive(true);
                }


                repository.save(tempNotice);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
