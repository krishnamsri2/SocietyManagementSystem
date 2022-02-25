package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.repository.RoleRepository;
import com.example.ProjectLatest.repository.UserDetailRepository;
import com.example.ProjectLatest.repository.UserRepository;
import com.example.ProjectLatest.to.LoginTO;
import com.example.ProjectLatest.to.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService  {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserDetailRepository userDetailRepository;
    @Autowired
    private RoleRepository roleRepository;


    public User verifyUser(String emailId, String password) {
        User user = null;
        try{
            System.out.println(emailId);
            System.out.println(password);
            user = repository.findByEmailId(emailId).orElse(null);
        }catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }
}
