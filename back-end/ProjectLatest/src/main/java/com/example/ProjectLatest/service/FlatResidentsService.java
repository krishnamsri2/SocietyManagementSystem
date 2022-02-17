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

    public void saveFlatResident(FlatResidentTO requestObject, Token token) {
        UserDetails tempUD = udRepo.getById(requestObject.getUserDetailId());
        Flat tempFlat = flatRepo.getById(requestObject.getFlatId());

        FlatResidents temp = new FlatResidents(requestObject.isOwner(),requestObject.isTenant(),
                token.getUserId(), tempFlat,tempUD);
        frRepo.save(temp);

    }

    public void updateFlatResident(long id, FlatResidentTO requestObject, Token token) {
        FlatResidents temp = frRepo.findById(id).orElse(null);
        temp.setTenant(requestObject.isTenant());
        temp.setOwner(requestObject.isOwner());
        temp.setFlat(flatRepo.getById(requestObject.getFlatId()));
        temp.setUserDetail(udRepo.getById(requestObject.getUserDetailId()));
    }

    public String deleteFlatResident(long id) {
        FlatResidents tempUsers  = frRepo.findById(id).orElse(null);
        tempUsers.setIsActive(false);
        tempUsers.setIsDeleted(true);

        frRepo.save(tempUsers);

        return "User removed !!" +id;
    }

    public FlatResidentResponse getFlatResidentById(long id) {
        FlatResidents tempUsers  = frRepo.findById(id).orElse(null);
        FlatResidentResponse copy = new FlatResidentResponse(tempUsers.isOwner(), tempUsers.isTenant(), tempUsers.getFlat().getFlatid(),
                tempUsers.getUserDetail().getUserDetailsId(),tempUsers.getUserDetail().getFirstName(),tempUsers.getUserDetail().getLastName(),
                tempUsers.getUserDetail().getPhoneNumber(),tempUsers.getUserDetail().getEmailId());
        return copy;
    }

    public List<FlatResidentResponse> getFlatResidentsByFlatId(long flatId) {
       List<FlatResidents> temp =  frRepo.findAllByFlatId(flatId);

       List<FlatResidentResponse> copy = temp.stream()
               .map(FlatResidents -> new FlatResidentResponse(FlatResidents.isOwner(), FlatResidents.isTenant(), FlatResidents.getFlat().getFlatid(),
                       FlatResidents.getUserDetail().getUserDetailsId(),FlatResidents.getUserDetail().getFirstName(),FlatResidents.getUserDetail().getLastName(),
                       FlatResidents.getUserDetail().getPhoneNumber(),FlatResidents.getUserDetail().getEmailId()))
               .collect(Collectors.toList());

       return copy;

    }

    public List<FlatResidentResponse> getFlatResidentsByUserDetailId(long userDetailId) {
        List<FlatResidents> temp =  frRepo.findAllByUserDetailId(userDetailId);

        List<FlatResidentResponse> copy = temp.stream()
                .map(FlatResidents -> new FlatResidentResponse(FlatResidents.isOwner(), FlatResidents.isTenant(), FlatResidents.getFlat().getFlatid(),
                        FlatResidents.getUserDetail().getUserDetailsId(),FlatResidents.getUserDetail().getFirstName(),FlatResidents.getUserDetail().getLastName(),
                        FlatResidents.getUserDetail().getPhoneNumber(),FlatResidents.getUserDetail().getEmailId()))
                .collect(Collectors.toList());

        return copy;
    }
}
