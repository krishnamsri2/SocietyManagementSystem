package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.repository.ChangePasswordRepository;
import com.example.ProjectLatest.repository.UserRepository;
import com.example.ProjectLatest.response.ChangePasswordResponse;
import com.example.ProjectLatest.response.SocietyResponse;
import com.example.ProjectLatest.to.ChangePasswordTO;
import com.example.ProjectLatest.to.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChangePasswordService {

    @Autowired
    private UserRepository userRepository;

    public ChangePasswordResponse updatePassword(ChangePasswordTO requestObject, Token token) {
        ChangePasswordResponse changePasswordResponse=new ChangePasswordResponse("NOT UPDATED");
        try
        {
            User user=userRepository.findByEmailId(requestObject.getEmailId()).orElse(null);

            if(user!=null)
            {
                if(user.getPassword().equals(requestObject.getOldPassword()))
                {
                    user.setPassword(requestObject.getNewPassword(), token.getUserId());
                    userRepository.save(user);
                    changePasswordResponse.setAck("UPDATED");
                }
                else
                {
                    changePasswordResponse.setAck("PASSWORD DIDN'T MATCH");
                }
            }
            else
            {
                changePasswordResponse.setAck("User not found");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return changePasswordResponse;
    }
}
