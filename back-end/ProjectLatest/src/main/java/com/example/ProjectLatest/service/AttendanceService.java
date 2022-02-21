package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.Attendance;
import com.example.ProjectLatest.entity.UserDetails;
import com.example.ProjectLatest.repository.AttendanceRepository;
import com.example.ProjectLatest.repository.UserDetailRepository;
import com.example.ProjectLatest.response.AttendanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private UserDetailRepository repository;
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


    public List<AttendanceResponse> getUserAttendances(long id) {
        List<AttendanceResponse> responses = null;
        try {
            UserDetails tempUsers = repository.findById(id).orElse(null);
            if(tempUsers != null ) {
                List<Attendance> tempAttendances = new ArrayList<>();

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
