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
        Society temp=repository1.findById(id).orElse(null);
        Tower tow=new Tower(requestObject.getTowerName(), token.getUserId(), requestObject.isDeleted(), requestObject.isActive(), temp);
        repository.save(tow);
    }

    public List<TowerResponse> findAllById(long id) {
        Society temp=repository1.findById(id).orElse(null);
        List<Tower> tower=temp.getTow();
        List<TowerResponse> copy = tower.stream()
                .map(Tower-> new TowerResponse(Tower.getTowerName(),Tower.getCreatedBy(),Tower.getCreated()))
                .collect(Collectors.toList());
        return  copy;
    }

    public void updateTower(long id, TowerTO requestObject, String tower_name) {
        Society temp=repository1.findById(id).orElse(null);
        List<Tower> tow=temp.getTow();
        for(int i=0;i<tow.size();i++)
        {
            Tower tp =tow.get(i);
            if(tp.getTowerName().equals(tower_name))
            {
                tp.setTowerName(requestObject.getTowerName());
            }
        }
        return;
    }
    public void deleteTower(long id, String tower_name) {
        Society temp=repository1.findById(id).orElse(null);
        List<Tower> tow=temp.getTow();
        for(int i=0;i<tow.size();i++) {
            Tower tp = tow.get(i);
            if (tp.getTowerName().equals(tower_name)) {
                tp.setDeleted(true);
            }
        }
        return;
    }

    public TowerResponse findById(long id, long tower_id) {
        Society temp=repository1.findById(id).orElse(null);
        List<Tower> tow=temp.getTow();
        Tower tower=null;
        for(int i=0;i<tow.size();i++)
        {
            Tower tp=tow.get(i);
            if(tp.getTowerId()==tower_id)
            {
                tower=tp;
                break;
            }
        }
        TowerResponse towerResponse=new TowerResponse(tower.getTowerName(), tower.getCreatedBy(),tower.getCreated());
        return towerResponse;
    }


    // update by Towername

}
