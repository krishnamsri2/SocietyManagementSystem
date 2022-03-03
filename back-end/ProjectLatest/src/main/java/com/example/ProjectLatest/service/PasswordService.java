 package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.repository.UserRepository;
import com.example.ProjectLatest.response.PasswordResponse;
import com.example.ProjectLatest.to.PasswordTO;
import com.example.ProjectLatest.to.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

 @Service
 public class PasswordService {

     @Autowired
     private UserRepository userRepository;
     @Autowired
     private EmailService emailService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    public void forgotPassword(PasswordTO requestObject, Token token, HttpServletRequest request) {

        PasswordResponse passwordResponse=new PasswordResponse("");
        User user= userRepository.findByEmailId(requestObject.getEmailId()).orElse(null);
        System.out.println(requestObject.getEmailId());
        if(user!=null)
        {
            user.setResetToken(UUID.randomUUID().toString());
            userRepository.save(user);

            String appUrl = request.getScheme() + "://" + request.getServerName();

            // Email message
            SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
            passwordResetEmail.setFrom("support@demo.com");
            passwordResetEmail.setTo(user.getEmailId());
            passwordResetEmail.setSubject("Password Reset Request");
            passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl
                    + "/reset?token=" + user.getResetToken());

            emailService.sendEmail(passwordResetEmail);
            passwordResponse.setAck("Success");
        }
        else
        {
            passwordResponse.setAck("user not found");
        }

        System.out.println(passwordResponse.getAck());

    }


    public void setNewPassword(PasswordTO requestObject, Token token, RedirectAttributes redirectAttributes) {

        PasswordResponse passwordResponse=new PasswordResponse("");
        User user=userRepository.findByResetToken(requestObject.getToken()).orElse(null);
        if(user!=null) {
            user.setPassword(bCryptPasswordEncoder.encode(requestObject.getNewPassword()), token.getUserId());
            user.setResetToken(null);
            userRepository.save(user);
            passwordResponse.setAck("reset");
        }
        else
        {
            passwordResponse.setAck("User not found");
        }
        System.out.println(passwordResponse.getAck());
    }
}
