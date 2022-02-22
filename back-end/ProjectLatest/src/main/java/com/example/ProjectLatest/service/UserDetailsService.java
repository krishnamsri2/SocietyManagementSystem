package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.entity.UserDetails;
import com.example.ProjectLatest.repository.UserDetailsRepository;
import com.example.ProjectLatest.repository.UserRepository;
import com.example.ProjectLatest.to.UserDetailsTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsService
{
    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Autowired
    UserRepository userRepository;

    public void saveUserDetails(UserDetailsTO userDetailsTO,Long userId)
    {
        User user = userRepository.getById(userId);
        UserDetails temp = new UserDetails(userDetailsTO.getFirstName(),userDetailsTO.getLastName(),userDetailsTO.getPhoneNumber(),userDetailsTO.getEmailId(),userId,user);
        userDetailsRepository.save(temp);
    }

    public List<UserDetails> getUserDetails()
    {
        return userDetailsRepository.findAll();
    }
}
