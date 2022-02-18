package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.Flat;
import com.example.ProjectLatest.entity.FlatResidents;
import com.example.ProjectLatest.entity.UserDetails;
import com.example.ProjectLatest.repository.FlatRepository;
import com.example.ProjectLatest.repository.FlatResidentsRepository;
import com.example.ProjectLatest.repository.UserDetailRepository;
import com.example.ProjectLatest.response.FlatResidentResponse;
import com.example.ProjectLatest.to.FlatResidentTO;
import com.example.ProjectLatest.to.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlatResidentsService {
    @Autowired
    private UserDetailRepository udRepo;
    @Autowired
    private FlatRepository flatRepo;
    @Autowired
    private FlatResidentsRepository frRepo;

    public String saveFlatResident(FlatResidentTO requestObject, Token token) {
        try {
            UserDetails tempUD = udRepo.getById(requestObject.getUserDetailId());
            Flat tempFlat = flatRepo.getById(requestObject.getFlatId());

            FlatResidents temp = new FlatResidents(requestObject.getIsOwner(), requestObject.getIsTenant(),
                    token.getUserId(), tempFlat, tempUD);
            frRepo.save(temp);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "New FlatResident is Added!";

    }

    public String updateFlatResident(long id, FlatResidentTO requestObject, Token token) {
        String acknow = null;
        try {
            FlatResidents temp = frRepo.findById(id).orElse(null);
            if(temp != null && temp.getIsDeleted() == false) {
                temp.setTenant(requestObject.getIsTenant());
                //System.out.println(requestObject.getIsOwner());
                temp.setOwner(requestObject.getIsOwner());
                temp.setFlat(flatRepo.getById(requestObject.getFlatId()));
                temp.setUserDetail(udRepo.getById(requestObject.getUserDetailId()));
                frRepo.save(temp);
                acknow = "Flat Resident is Updated";
            }else{
                acknow = "Not found FlatResident";
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return acknow;
    }

    public String deleteFlatResident(long id) {
        try {
            FlatResidents tempUsers = frRepo.findById(id).orElse(null);

            if(tempUsers != null && tempUsers.getIsDeleted() == false) {
                tempUsers.setIsActive(false);
                tempUsers.setIsDeleted(true);

                frRepo.save(tempUsers);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        return "User removed !!" +id;
    }

    public FlatResidentResponse getFlatResidentById(long id) {
        FlatResidentResponse copy = null;
        try {
            FlatResidents tempUsers = frRepo.findById(id).orElse(null);
            if(tempUsers != null && tempUsers.getIsDeleted() == false) {
                copy = new FlatResidentResponse(tempUsers.isOwner(), tempUsers.isTenant(), tempUsers.getFlat().getFlatId(),
                        tempUsers.getUserDetail().getUserDetailsId(), tempUsers.getUserDetail().getFirstName(), tempUsers.getUserDetail().getLastName(),
                        tempUsers.getUserDetail().getPhoneNumber(), tempUsers.getUserDetail().getEmailId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return copy;
    }

    public List<FlatResidentResponse> getFlatResidentsByFlatId(long flatId) {
        List<FlatResidentResponse> copy = null;
        try {

            List<FlatResidents> temp = frRepo.findAllByFlatId(flatId);
            if(temp != null) {
                copy = temp.stream()
                        .map(FlatResidents -> new FlatResidentResponse(FlatResidents.isOwner(), FlatResidents.isTenant(), FlatResidents.getFlat().getFlatId(),
                                FlatResidents.getUserDetail().getUserDetailsId(), FlatResidents.getUserDetail().getFirstName(), FlatResidents.getUserDetail().getLastName(),
                                FlatResidents.getUserDetail().getPhoneNumber(), FlatResidents.getUserDetail().getEmailId()))
                        .collect(Collectors.toList());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       return copy;

    }

    public List<FlatResidentResponse> getFlatResidentsByUserDetailId(long userDetailId) {
        List<FlatResidentResponse> copy = null;

        try {
            List<FlatResidents> temp = frRepo.findAllByUserDetailId(userDetailId);
            if(temp != null) {
                copy = temp.stream()
                        .map(FlatResidents -> new FlatResidentResponse(FlatResidents.isOwner(), FlatResidents.isTenant(), FlatResidents.getFlat().getFlatId(),
                                FlatResidents.getUserDetail().getUserDetailsId(), FlatResidents.getUserDetail().getFirstName(), FlatResidents.getUserDetail().getLastName(),
                                FlatResidents.getUserDetail().getPhoneNumber(), FlatResidents.getUserDetail().getEmailId()))
                        .collect(Collectors.toList());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return copy;
    }
}
