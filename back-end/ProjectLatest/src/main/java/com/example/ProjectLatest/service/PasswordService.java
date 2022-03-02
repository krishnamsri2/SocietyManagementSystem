package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.repository.UserRepository;
import com.example.ProjectLatest.to.PasswordTO;
import com.example.ProjectLatest.to.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class PasswordService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;

    public void forgotPassword(PasswordTO requestObject, Token token, HttpServletRequest request) {


    }
}
