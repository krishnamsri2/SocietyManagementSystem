package com.example.ProjectLatest.service;

import com.example.ProjectLatest.builder.FlatResidentBuilder;
import com.example.ProjectLatest.builder.FlatResidentResBuilder;
import com.example.ProjectLatest.entity.Flat;
import com.example.ProjectLatest.entity.FlatResidents;
import com.example.ProjectLatest.entity.UserDetails;
import com.example.ProjectLatest.repository.FlatRepository;
import com.example.ProjectLatest.repository.FlatResidentsRepository;
import com.example.ProjectLatest.repository.TowerRepository;
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
    @Autowired
    private TowerRepository towerRepository;

    //POST
    public void saveFlatResident(FlatResidentTO requestObject, Token token) {
        try {
            UserDetails tempUD = udRepo.findById(requestObject.getUserDetailId()).orElse(null);

            long towerId =  towerRepository.getByTowerName(requestObject.getTowerName(), token.getSocietyId()).getTowerId();
            Flat tempFlat =   flatRepo.getByFlatNo(requestObject.getFlatNo(),towerId );

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
    public void updateFlatResident(FlatResidentTO requestObject, Token token) {
        try {
            FlatResidents temp = frRepo.findById(requestObject.getFlatResId()).orElse(null);

            if(temp != null && temp.getIsDeleted() == false ) {
                temp.setTenant(requestObject.getIsTenant());
                temp.setOwner(requestObject.getIsOwner());
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
            if(tempUsers != null ){
                if(tempUsers.getIsDeleted() == false) {
                tempUsers.setIsActive(false);
                tempUsers.setIsDeleted(true);
            }else{
                    tempUsers.setIsActive(true);
                    tempUsers.setIsDeleted(false);
                }
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
            if(tempUsers != null) {
                copy = new FlatResidentResBuilder()
                        .setFlatResId(tempUsers.getFlatResId())
                        .setFlatNo(tempUsers.getFlat().getFlatNo())
                        .setIsOwner(tempUsers.isOwner())
                        .setIsTenant(tempUsers.isTenant())
                        .setTowerName(tempUsers.getFlat().getTow2().getTowerName())
                        .setIsDeleted(tempUsers.getIsDeleted())
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
                                .setFlatResId(FlatResidents.getFlatResId())
                                .setFlatNo(FlatResidents.getFlat().getFlatNo())
                                .setIsOwner(FlatResidents.isOwner())
                                .setIsTenant(FlatResidents.isTenant())
                                .setTowerName(FlatResidents.getFlat().getTow2().getTowerName())
                                .setIsDeleted(FlatResidents.getIsDeleted())
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
                                .setFlatResId(FlatResidents.getFlatResId())
                                .setFlatNo(FlatResidents.getFlat().getFlatNo())
                                .setIsOwner(FlatResidents.isOwner())
                                .setIsTenant(FlatResidents.isTenant())
                                .setTowerName(FlatResidents.getFlat().getTow2().getTowerName())
                                .setIsDeleted(FlatResidents.getIsDeleted())
                                .getResponse())
                        .collect(Collectors.toList());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return copy;
    }
}
