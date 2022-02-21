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
    //POST
    public void saveAttendance(long id) {
        try {
            UserDetails existingUser = repository.findById(id).orElse(null);
            if(existingUser != null && existingUser.getIsDeleted() == false) {
                Attendance tempAtten = new Attendance(existingUser);
                attendanceRepository.save(tempAtten);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //POST
    public void updateAttendance(long userId) {
        try {
            Date date = new Date();
            Attendance tempAtten = attendanceRepository.findByUserDetailId(userId, date.toString().substring(0, 10));
            if(tempAtten != null || tempAtten.getIsDeleted() == false) {
                tempAtten.setPunchOut();
                attendanceRepository.save(tempAtten);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //GET
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

    //DELETE
    public void deleteUserAttendance(long id) {
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
   }

}
