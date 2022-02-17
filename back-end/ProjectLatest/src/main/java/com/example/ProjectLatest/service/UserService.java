package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.repository.UserRepository;
import com.example.ProjectLatest.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserTO userTO)
    {
        System.out.println(userTO);
        System.out.println(userTO.getPassword());

        User userTemp = new User(userTO.getPassword(),112L);
        userRepository.save(userTemp);
    }

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
}
