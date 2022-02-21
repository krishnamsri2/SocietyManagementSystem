package com.example.ProjectLatest.service;

import com.example.ProjectLatest.builder.FlatResidentBuilder;
import com.example.ProjectLatest.builder.UserDetailBuilder;
import com.example.ProjectLatest.builder.UserDetailsResBuilder;
import com.example.ProjectLatest.entity.*;
import com.example.ProjectLatest.repository.*;
import com.example.ProjectLatest.response.AttendanceResponse;
import com.example.ProjectLatest.response.UserDetailsResponse;
import com.example.ProjectLatest.response.UserFlatResponse;
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
    private FlatRepository flatRepository;
    @Autowired
    private TowerRepository towerRepository;
    @Autowired
    private FlatResidentsRepository flatResidentsRepository;


    //POST
    public void saveUser(UserTO user, Token token){
        try{
            User tempUser = new User(user.getPassword(),token.getUserId());
            repoUser.save(tempUser);
            UserDetails tempUd = new UserDetails(user.getFirstName(),user.getLastName(),
                    user.getPhoneNumber(),user.getEmailId(),token.getUserId(),tempUser);
            repository.save(tempUd);

            long towerId =  towerRepository.getByTowerName(user.getTowerName(), token.getSocietyId()).getTowerId();
            Flat flat =   flatRepository.getByFlatNo(user.getFlatNo(),towerId );

            if(flat != null) {
                FlatResidents tempFR = new FlatResidentBuilder()
                        .setOwner(false)
                        .setTenant(false)
                        .setCreatedBy(token.getUserId())
                        .setFlat(flat )
                        .setUserDetail(tempUd)
                        .getResponse();
                flatResidentsRepository.save(tempFR);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    //PUT
    public void updateUser(long id,UserTO user,Token token){

        try {
            UserDetails existingUser = repository.findById(id).orElse(null);

            if(existingUser != null && existingUser.getIsDeleted() == false) {
                existingUser.setFirstName(user.getFirstName(), token.getUserId());
                existingUser.setLastName(user.getLastName(), token.getUserId());
                existingUser.setEmailId(user.getEmailId(), token.getUserId());
                existingUser.setPhoneNumber(user.getPhoneNumber(), token.getUserId());
                repository.save(existingUser);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return acknow;
        }

    }

   //GET

    public UserDetailsResponse getUserById(long id){
        UserDetailsResponse copy = null;

        try {
             UserDetails tempUsers = repository.findById(id).orElse(null);
             if(tempUsers != null && tempUsers.getIsDeleted() == false)
             //copy = new UserDetailsResponse(tempUsers.getUserDetailsId(),tempUsers.getFirstName(), tempUsers.getLastName(), tempUsers.getPhoneNumber(), tempUsers.getEmailId(), tempUsers.getUser().getPassword());
             copy = new UserDetailsResBuilder()
                     .setFirstName(tempUsers.getFirstName())
                     .setLastName(tempUsers.getLastName())
                     .setPhoneNumber(tempUsers.getPhoneNumber())
                     .setEmailId(tempUsers.getEmailId())
                     .setUserDetailId(tempUsers.getUserDetailsId())
                     .getResponse();
        }catch (Exception e){
            e.printStackTrace();
        }
            return copy;

    }

        public List<UserDetailsResponse> getAllUser(){
        List<UserDetailsResponse> copy = new ArrayList<>();

        try {
            for(UserDetails x : repository.findAll()){
                if(x.getIsDeleted() == false){
                    copy.add(new UserDetailsResBuilder()
                            .setUserDetailId(x.getUserDetailsId())
                            .setFirstName(x.getFirstName())
                            .setLastName(x.getLastName())
                            .setPhoneNumber(x.getPhoneNumber())
                            .setEmailId(x.getEmailId())
                            .getResponse());

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return responses;
        }

    }

    public List<UserFlatResponse> getFlatDetails(long id){
        List<UserFlatResponse> tempL = new ArrayList<>();
        try {
             tempL = new ArrayList<UserFlatResponse>();
            for (FlatResidents y : repository.getById(id).getFlatResidents()) {
                if (y.getIsDeleted() == false) {
                    tempL.add(new UserFlatResponse(y.getFlat().getTow2().getTowerName(), y.getFlat().getFlatNo()));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return tempL;
    }


    //DELETE
    public void deleteUser(long id){
        try {
            UserDetails tempUsers = repository.findById(id).orElse(null);
            if(tempUsers != null) {
                tempUsers.setIsActive(false, tempUsers.getModifiedBy());
                tempUsers.setIsDeleted(true, tempUsers.getModifiedBy());
                tempUsers.getUser().setIsActive(false, tempUsers.getModifiedBy());
                tempUsers.getUser().setIsDeleted(true);
                repository.save(tempUsers);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    public String deleteUserAttendance(long id) {
        try {
            Attendance tempAtten = attendanceRepository.findById(id).orElse(null);
            if(tempAtten != null) {
                tempAtten.setIsDeleted(true);
                tempAtten.setIsActive(false);
                attendanceRepository.save(tempAtten);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return "User's Attendance removed !!" +id;
        }

    }
}
