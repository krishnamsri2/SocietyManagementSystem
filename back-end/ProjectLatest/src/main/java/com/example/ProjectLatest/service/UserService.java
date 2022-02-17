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
    public void saveUser(UserTO user, Token token){
        User tempUser = new User(user.getPassword(),token.getUserId());
        repoUser.save(tempUser);
        UserDetails tempUd = new UserDetails(user.getFirstName(),user.getLastName(),
                user.getPhoneNumber(),user.getEmailId(),token.getUserId(),tempUser);
         repository.save(tempUd);
    }

    public void saveAttendance(long id) {
        UserDetails existingUser=repository.findById(id).orElse(null);
        Attendance tempAtten = new Attendance(existingUser);
        attendanceRepository.save(tempAtten);
    }


    //PUT
    public void updateUser(long id,UserTO user,Token token){
        UserDetails existingUser=repository.findById(id).orElse(null);
        existingUser.setFirstName(user.getFirstName(), token.getUserId());
        existingUser.setLastName(user.getLastName(), token.getUserId());
        existingUser.setEmailId(user.getEmailId(), token.getUserId());
        existingUser.setPhoneNumber(user.getPhoneNumber(), token.getUserId());
        existingUser.getUser().setPassword(user.getPassword(), token.getUserId());

         repository.save(existingUser);

    }

    public void updateAttendance(long id) {
        Attendance tempAtten = attendanceRepository.findById(id).orElse(null);
        tempAtten.setPunchOut();
        attendanceRepository.save(tempAtten);
    }


    //GET
    public UserDetailsResponse getUserById(long id){
        UserDetails tempUsers  = repository.findById(id).orElse(null);
        UserDetailsResponse copy = new UserDetailsResponse(tempUsers.getFirstName(),tempUsers.getLastName(),tempUsers.getPhoneNumber(), tempUsers.getEmailId(),tempUsers.getUser().getPassword());
        return copy;
    }

    public List<AttendanceResponse> getUserAttendances(long id) {
        UserDetails tempUsers  = repository.findById(id).orElse(null);
        List<Attendance> tempAttendances = new ArrayList<Attendance>();
        tempAttendances.addAll(tempUsers.getSetAttendance());

        List<AttendanceResponse> responses = tempAttendances.stream()
                .map(Attendance -> new AttendanceResponse(Attendance.getAttendId(),Attendance.getPunchIn(),Attendance.getPunchOut()))
                .collect(Collectors.toList());


        return responses;
    }

    //DELETE
    public String deleteUser(long id){
        UserDetails tempUsers  = repository.findById(id).orElse(null);
        tempUsers.setIsActive(false, tempUsers.getModifiedBy());
        tempUsers.setIsDeleted(true, tempUsers.getModifiedBy());
        tempUsers.getUser().setIsActive(false, tempUsers.getModifiedBy());
        tempUsers.getUser().setIsDeleted(true);

        repository.save(tempUsers);

        return "User removed !!" +id;
    }


    public String deleteUserAttendance(long id) {
        Attendance tempAtten = attendanceRepository.findById(id).orElse(null);
        tempAtten.setIsDeleted(true);
        tempAtten.setIsActive(false);
        attendanceRepository.save(tempAtten);

        return "User's Attendance removed !!" +id;
    }
}
