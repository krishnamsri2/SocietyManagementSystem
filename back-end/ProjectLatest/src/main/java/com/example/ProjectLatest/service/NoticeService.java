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
            Notice tempNotice = new Notice(notice.getNoticeDetail(), token.getUserId(), notice.getUserId());
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
                existingNotice.setNoticeDetail(notice.getNoticeDetail());
                existingNotice.setUserId(notice.getUserId());

                repository.save(existingNotice);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //GET
    public List<NoticeResponse> getNotices(){
        List<NoticeResponse> copy = null;
        try {
            List<Notice> tempNotices = repository.findAll();

             copy = tempNotices.stream()
                    .map(Notice -> new NoticeResBuilder()
                            .setNoticeId(Notice.getNoticeId())
                            .setNoticeDetail(Notice.getNoticeDetail())
                            .setCreatedBy(Notice.getCreatedBy())
                            .setCreatedDate(Notice.getCreatedDate())
                            .setUpdatedDate(Notice.getUpdatedDate())
                            .getResponse())
                    .collect(Collectors.toList());
        }catch (Exception e){
            e.printStackTrace();
        }

        return copy;
    }

    public NoticeResponse getNoticeById(long id){
        NoticeResponse copy = null;
        try {
            Notice tempNotice = repository.findById(id).orElse(null);

            if (tempNotice != null && tempNotice.isDeleted() == false) {
                copy = new NoticeResBuilder()
                        .setNoticeId(tempNotice.getNoticeId())
                        .setNoticeDetail(tempNotice.getNoticeDetail())
                        .setCreatedBy(tempNotice.getCreatedBy())
                        .setCreatedDate(tempNotice.getCreatedDate())
                        .setUpdatedDate(tempNotice.getUpdatedDate())
                        .getResponse();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return copy;
    }

    //DELETE
    public void deleteNotice(long id){
        try {
            Notice tempNotice = repository.findById(id).orElse(null);
            if(tempNotice != null && tempNotice.isDeleted() == false){
                tempNotice.setDeleted(true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
