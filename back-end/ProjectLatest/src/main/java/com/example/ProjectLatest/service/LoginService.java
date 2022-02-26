package com.example.ProjectLatest.service;

import com.example.ProjectLatest.builder.LoginResBuilder;
import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.entity.UserDetails;
import com.example.ProjectLatest.repository.RoleRepository;
import com.example.ProjectLatest.repository.UserDetailRepository;
import com.example.ProjectLatest.repository.UserRepository;
import com.example.ProjectLatest.response.LoginResponse;
import com.example.ProjectLatest.to.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.ProjectLatest.Security.Interceptor.hashMemory;

@Service
public class LoginService  {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserDetailRepository userDetailRepository;



    public User verifyUser(String emailId, String password) {
        User user = null;
        try{
            user = repository.findByEmailId(emailId).orElse(null);

            if(user == null || !user.getPassword().equals(password)) {
                user = null;
                throw new Exception("User Not Found");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }

    public LoginResponse createToken(String emailId){
        LoginResponse response = null;
        try {
            User user = repository.findByEmailId(emailId).orElse(null);
            Token token = new Token();
            token.setSocietyId(user.getSocietyId());
            token.setUserId(user.getUserId());

            hashMemory.put(user.getUserId(),token);

            UserDetails usd = userDetailRepository.getByUserId(user.getUserId());

             response = new LoginResBuilder()
                    .setFirstName(usd.getFirstName())
                    .setLastName(usd.getLastName())
                    .setEmailId(usd.getEmailId())
                    .setPhoneNumber(usd.getPhoneNumber())
                    .setUserId(token.getUserId())
                    .setSocietyId(token.getSocietyId())
                    .getResponse();

        }catch (Exception e){
           e.printStackTrace();
        }
        return response;
    }
}
