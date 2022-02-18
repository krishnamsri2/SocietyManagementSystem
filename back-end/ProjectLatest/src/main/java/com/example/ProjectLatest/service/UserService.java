package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.Attendance;
import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.entity.UserDetails;
import com.example.ProjectLatest.repository.AttendanceRepository;
import com.example.ProjectLatest.repository.UserDetailRepository;
import com.example.ProjectLatest.repository.UserRepository;
import com.example.ProjectLatest.response.AttendanceResponse;
import com.example.ProjectLatest.response.UserDetailsResponse;
import com.example.ProjectLatest.to.Token;
import com.example.ProjectLatest.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserDetailRepository repository;
    @Autowired
    private UserRepository repoUser;
    @Autowired
    private AttendanceRepository attendanceRepository;


    //POST
    public String saveUser(UserTO user, Token token){
        try{
            User tempUser = new User(user.getPassword(),token.getUserId());
            repoUser.save(tempUser);
            UserDetails tempUd = new UserDetails(user.getFirstName(),user.getLastName(),
                    user.getPhoneNumber(),user.getEmailId(),token.getUserId(),tempUser);
            repository.save(tempUd);
        }catch (Exception e){
            e.printStackTrace();
        }
            return "New User is Added!";

    }

    public String saveAttendance(long id) {
        String acknow = null;
        try {
            UserDetails existingUser = repository.findById(id).orElse(null);
            if(existingUser == null)
                acknow =  "No User Found";
            else {
                Attendance tempAtten = new Attendance(existingUser);
                attendanceRepository.save(tempAtten);
                acknow =  "User Punched In";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
            return acknow;

    }


    //PUT
    public String updateUser(long id,UserTO user,Token token){
        String acknow = null;
        try {
            UserDetails existingUser = repository.findById(id).orElse(null);

            if(existingUser == null|| existingUser.getIsDeleted() == true)
                acknow =  "No User Found";
            else {
                existingUser.setFirstName(user.getFirstName(), token.getUserId());
                existingUser.setLastName(user.getLastName(), token.getUserId());
                existingUser.setEmailId(user.getEmailId(), token.getUserId());
                existingUser.setPhoneNumber(user.getPhoneNumber(), token.getUserId());
                existingUser.getUser().setPassword(user.getPassword(), token.getUserId());
                repository.save(existingUser);

                acknow = "User "+ id+" is Updated";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
            return acknow;

    }

    public String updateAttendance(long userId) {
        String acknow = null;
        try {
            Date date = new Date();
            Attendance tempAtten = attendanceRepository.findByUserDetailId(userId, date.toString().substring(0, 10));
            if(tempAtten == null || tempAtten.getIsDeleted() == true)
                acknow =  "No User Found";
            else {
                tempAtten.setPunchOut();
                attendanceRepository.save(tempAtten);
                acknow = "User "+ userId+" is Punched Out";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
            return acknow;

    }


    //GET
    public UserDetailsResponse getUserById(long id){
        UserDetailsResponse copy = null;

        try {
             UserDetails tempUsers = repository.findById(id).orElse(null);
             if(tempUsers != null && tempUsers.getIsDeleted() == false)
             copy = new UserDetailsResponse(tempUsers.getUserDetailsId(),tempUsers.getFirstName(), tempUsers.getLastName(), tempUsers.getPhoneNumber(), tempUsers.getEmailId(), tempUsers.getUser().getPassword());
        }catch (Exception e){
            e.printStackTrace();
        }
            return copy;

    }

    public List<AttendanceResponse> getUserAttendances(long id) {
        List<AttendanceResponse> responses = null;
        try {
            UserDetails tempUsers = repository.findById(id).orElse(null);
            if(tempUsers != null ) {
                List<Attendance> tempAttendances = new ArrayList<Attendance>();

                for(Attendance att : tempUsers.getSetAttendance()){
                    if(att.getIsDeleted() == false)
                    tempAttendances.add(att);
                }

                responses = tempAttendances.stream()
                        .map(Attendance -> new AttendanceResponse(Attendance.getAttendId(), Attendance.getCreateDate(), Attendance.getUpdateDate()))
                        .collect(Collectors.toList());

            }

        }catch (Exception e){
            e.printStackTrace();
        }
            return responses;


    }

    //DELETE
    public String deleteUser(long id){
        try {
            UserDetails tempUsers = repository.findById(id).orElse(null);
            if(tempUsers != null && tempUsers.getIsDeleted() == false) {
                tempUsers.setIsActive(false, tempUsers.getModifiedBy());
                tempUsers.setIsDeleted(true, tempUsers.getModifiedBy());
                tempUsers.getUser().setIsActive(false, tempUsers.getModifiedBy());
                tempUsers.getUser().setIsDeleted(true);
                repository.save(tempUsers);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
            return "User removed !!" +id;


    }


    public String deleteUserAttendance(long id) {
        try {
            Attendance tempAtten = attendanceRepository.findById(id).orElse(null);
            if(tempAtten != null && tempAtten.getIsDeleted() == false) {
                tempAtten.setIsDeleted(true);
                tempAtten.setIsActive(false);
                attendanceRepository.save(tempAtten);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
            return "User's Attendance removed !!" +id;


    }
}
