package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.*;
import com.example.ProjectLatest.repository.FlatRepository;
import com.example.ProjectLatest.repository.SocietyRepository;
import com.example.ProjectLatest.repository.TowerRepository;
import com.example.ProjectLatest.response.FlatResponse;
import com.example.ProjectLatest.response.SocietyResponse;
import com.example.ProjectLatest.to.FlatTO;
import com.example.ProjectLatest.to.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlatService {

    @Autowired
    private FlatRepository flatRepository;
    @Autowired
    private SocietyRepository societyRepository;
    @Autowired
    private TowerRepository towerRepository;

// post to add flat
    public void addFlat(FlatTO requestObject, long tower_id, Token token) {
        try {
            Tower tower = towerRepository.findById(tower_id).orElse(null);
            if(tower!=null) {
                Flat flat = new Flat(requestObject.getFlatNo(), requestObject.isStatus(), requestObject.getNumberOfOccupant(), token.getUserId(), false, true, tower);
                flatRepository.save(flat);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return;
    }

    public List<FlatResponse> getAll(long tower_id) {
        List<FlatResponse> copy=new ArrayList<>();
        try {
            Tower tower = towerRepository.findById(tower_id).orElse(null);
            if(tower!=null && !tower.isDeleted()) {
                List<Flat> flats = tower.getFlat();
                List<Flat> flat=new ArrayList<>();
                for(int i=0;i<flats.size();i++)
                {
                    Flat tp=flats.get(i);
                    if(!tp.isDeleted())
                    {
                        flat.add(tp);
                    }
                }
                if(flat.size()!=0)
                copy = flat.stream()
                        .map(Flat -> new FlatResponse(Flat.getFlatNo(), Flat.isStatus(), Flat.getNumber_of_occupants(), Flat.getFlatId()))
                        .collect(Collectors.toList());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return copy;

    }
    // get all available flat

    public FlatResponse getById(long flat_id) {
        FlatResponse flatResponse=null;
        try {
            Flat flat = flatRepository.findById(flat_id).orElse(null);
            if(flat!=null && !flat.isDeleted())
            flatResponse = new FlatResponse(flat.getFlatNo(), flat.isStatus(), flat.getNumber_of_occupants(), flat.getFlatId());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  flatResponse;
    }

    public void updateStatus(long flat_id, FlatTO requestObject) {
        try {
            Flat flat = flatRepository.findById(flat_id).orElse(null);
            if(flat!=null && !flat.isDeleted()) {
                flat.setStatus(requestObject.isStatus());
                flatRepository.save(flat);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return;
    }
    public void updateOccupant(long flat_id, FlatTO requestObject) {
        try {
            Flat flat = flatRepository.findById(flat_id).orElse(null);
            if(flat!=null && !flat.isDeleted()) {
                flat.setNumber_of_occupants(requestObject.getNumberOfOccupant());
                flatRepository.save(flat);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return;
    }

    public void removeFlat(long flat_id) {
        try {
            Flat flat = flatRepository.findById(flat_id).orElse(null);
            if(flat!=null) {
                flat.setDeleted(true);
                flatRepository.save(flat);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return;
    }

    public List<FlatResponse> getAllAvailable(long tower_id) {
        List<FlatResponse> copy=new ArrayList<>();
        try {
            Tower tower = towerRepository.findById(tower_id).orElse(null);
            List<Flat> flats = tower.getFlat();
            List<Flat> flat = new ArrayList<>();
            for (int i = 0; i < flats.size(); i++) {
                Flat temp = flats.get(i);
                if (temp.isStatus() && !temp.isDeleted()) {
                    flat.add(temp);
                }
            }
            if(flat.size()!=0)
            copy = flat.stream()
                    .map(Flat -> new FlatResponse(Flat.getFlatNo(), Flat.isStatus(), Flat.getNumber_of_occupants(), Flat.getFlatId()))
                    .collect(Collectors.toList());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return copy;
    }
}
