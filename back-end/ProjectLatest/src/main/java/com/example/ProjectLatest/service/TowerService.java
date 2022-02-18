package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.Society;
import com.example.ProjectLatest.entity.Tower;
import com.example.ProjectLatest.repository.SocietyRepository;
import com.example.ProjectLatest.repository.TowerRepository;
import com.example.ProjectLatest.response.FlatResponse;
import com.example.ProjectLatest.response.TowerResponse;
import com.example.ProjectLatest.to.Token;
import com.example.ProjectLatest.to.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TowerService {
    @Autowired
    private TowerRepository repository;
    @Autowired
    private SocietyRepository repository1;


    public void addTower(long id, TowerTO requestObject, Token token) {
        try {
            Society temp = repository1.findById(id).orElse(null);
            if(temp!=null && !temp.isDeleted()) {
                Tower tow = new Tower(requestObject.getTowerName(), token.getUserId(), requestObject.isDeleted(), requestObject.isActive(), temp);
                repository.save(tow);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<TowerResponse> findAllById(long id) {
        List<TowerResponse> copy=null;
        try {
            Society temp = repository1.findById(id).orElse(null);
            if(temp!=null && !temp.isDeleted()) {
                List<Tower> tower = temp.getTow();
                copy = tower.stream()
                        .map(Tower -> new TowerResponse(Tower.getTowerName(), Tower.getCreatedBy(), Tower.getCreated()))
                        .collect(Collectors.toList());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  copy;
    }

    public void updateTower(long id, TowerTO requestObject) {
        try {
            Tower tower = repository.findById(requestObject.getTowerId()).orElse(null);
            if(tower!=null && !tower.isDeleted())
            tower.setTowerName(requestObject.getTowerName());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return;
    }

    public TowerResponse findById(long id, long tower_id) {
        TowerResponse towerResponse=null;
        try {
            Tower tower = repository.findById(tower_id).orElse(null);
            if (tower != null && !tower.isDeleted())
                towerResponse = new TowerResponse(tower.getTowerName(), tower.getCreatedBy(), tower.getCreated());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return towerResponse;
    }

    public void deleteTower(TowerTO tower) {
        try {
            Tower tow = repository.findById(tower.getTowerId()).orElse(null);
            if(tow!=null)
            tow.setDeleted(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return;

    }


    // update by Towername

}
