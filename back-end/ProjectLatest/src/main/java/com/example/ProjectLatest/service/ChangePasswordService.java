package com.example.ProjectLatest.service;


import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.repository.ChangePasswordRepository;
import com.example.ProjectLatest.response.ChangePasswordResponse;
import com.example.ProjectLatest.response.SocietyResponse;
import com.example.ProjectLatest.to.ChangePasswordTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordService {

    @Autowired
    private ChangePasswordRepository changePasswordRepository;

    public ChangePasswordResponse updatePassword(long user_id, ChangePasswordTO requestObject) {
        ChangePasswordResponse changePasswordResponse=new ChangePasswordResponse("NOT UPDATED");
        try
        {
            User user = changePasswordRepository.findById(user_id).orElse(null);
            if(user.getPassword().equals(requestObject.getOldPassword()))
            {
                if(requestObject.getNewPassword().equals(requestObject.getConfirmPassword()))
                {
                    changePasswordResponse.setAck("UPDATED");
                    user.setPassword(requestObject.getNewPassword(), requestObject.getUserId());
                    changePasswordRepository.save(user);
                }
                else
                {
                    changePasswordResponse.setAck("NEW PASSWORD DID NOT MATCH");
                }
            }
            else
            {
                changePasswordResponse.setAck("OLD PASSWORD DID NOT MATCH");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return changePasswordResponse;
    }
}
