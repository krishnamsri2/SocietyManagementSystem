package com.example.ProjectLatest.service;

import com.example.ProjectLatest.builder.FlatResidentBuilder;
import com.example.ProjectLatest.builder.FlatResidentResBuilder;
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

    //POST
    public void saveFlatResident(FlatResidentTO requestObject, Token token) {
        try {
            UserDetails tempUD = udRepo.findById(requestObject.getUserDetailId()).orElse(null);
            Flat tempFlat = flatRepo.findById(requestObject.getFlatId()).orElse(null);

//            FlatResidents temp = new FlatResidents(requestObject.getIsOwner(), requestObject.getIsTenant(),
//                    token.getUserId(), tempFlat, tempUD);

            if(tempUD != null && tempFlat != null) {
                FlatResidents temp = new FlatResidentBuilder()
                        .setOwner(requestObject.getIsOwner())
                        .setTenant(requestObject.getIsTenant())
                        .setCreatedBy(token.getUserId())
                        .setFlat(tempFlat)
                        .setUserDetail(tempUD)
                        .getResponse();
                frRepo.save(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //PUT
    public void updateFlatResident(long id, FlatResidentTO requestObject, Token token) {
        try {
            FlatResidents temp = frRepo.findById(id).orElse(null);
            if(temp != null && temp.getIsDeleted() == false) {
                temp.setTenant(requestObject.getIsTenant());
                temp.setOwner(requestObject.getIsOwner());
                temp.setFlat(flatRepo.getById(requestObject.getFlatId()));
                temp.setUserDetail(udRepo.getById(requestObject.getUserDetailId()));
                frRepo.save(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //DELETE
    public void deleteFlatResident(long id) {
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
    }

    //GET
    public FlatResidentResponse getFlatResidentById(long id) {
        FlatResidentResponse copy = null;
        try {
            FlatResidents tempUsers = frRepo.findById(id).orElse(null);
            if(tempUsers != null && tempUsers.getIsDeleted() == false) {
                copy = new FlatResidentResBuilder()
                        .setFirstName(tempUsers.getUserDetail().getFirstName())
                        .setEmailId(tempUsers.getUserDetail().getEmailId())
                        .setFlatId(tempUsers.getFlat().getFlatId())
                        .setFlatNo(tempUsers.getFlat().getFlatNo())
                        .setIsOwner(tempUsers.isOwner())
                        .setLastName(tempUsers.getUserDetail().getLastName())
                        .setPhoneNumber(tempUsers.getUserDetail().getPhoneNumber())
                        .setUserDetailId(tempUsers.getUserDetail().getUserDetailsId())
                        .setIsTenant(tempUsers.isTenant())
                        .setTowerName(tempUsers.getFlat().getTow2().getTowerName())
                        .getResponse();
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
                        .map(FlatResidents -> new FlatResidentResBuilder()
                                .setFirstName(FlatResidents.getUserDetail().getFirstName())
                                .setEmailId(FlatResidents.getUserDetail().getEmailId())
                                .setFlatId(FlatResidents.getFlat().getFlatId())
                                .setFlatNo(FlatResidents.getFlat().getFlatNo())
                                .setIsOwner(FlatResidents.isOwner())
                                .setLastName(FlatResidents.getUserDetail().getLastName())
                                .setPhoneNumber(FlatResidents.getUserDetail().getPhoneNumber())
                                .setUserDetailId(FlatResidents.getUserDetail().getUserDetailsId())
                                .setIsTenant(FlatResidents.isTenant())
                                .setTowerName(FlatResidents.getFlat().getTow2().getTowerName())
                                .getResponse())
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
                        .map(FlatResidents -> new FlatResidentResBuilder()
                                .setFirstName(FlatResidents.getUserDetail().getFirstName())
                                .setEmailId(FlatResidents.getUserDetail().getEmailId())
                                .setFlatId(FlatResidents.getFlat().getFlatId())
                                .setFlatNo(FlatResidents.getFlat().getFlatNo())
                                .setIsOwner(FlatResidents.isOwner())
                                .setLastName(FlatResidents.getUserDetail().getLastName())
                                .setPhoneNumber(FlatResidents.getUserDetail().getPhoneNumber())
                                .setUserDetailId(FlatResidents.getUserDetail().getUserDetailsId())
                                .setIsTenant(FlatResidents.isTenant())
                                .setTowerName(FlatResidents.getFlat().getTow2().getTowerName())
                                .getResponse())
                        .collect(Collectors.toList());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return copy;
    }
}
