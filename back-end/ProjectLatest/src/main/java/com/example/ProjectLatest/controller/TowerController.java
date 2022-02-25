package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.entity.Tower;
import com.example.ProjectLatest.response.TowerResponse;
import com.example.ProjectLatest.service.TowerService;
import com.example.ProjectLatest.to.RestRequest;
import com.example.ProjectLatest.to.TowerTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TowerController {
    @Autowired
    private TowerService services;

    // post
    @RequestMapping(method =RequestMethod.POST,value = "/society/{id}/addTower")
    public void addTower(@PathVariable long id, @RequestBody RestRequest<TowerTO> tower)
    {
         services.addTower(id,tower.getRequestObject(),tower.getToken());
    }

    // get request to find all by society id
    @RequestMapping(method = RequestMethod.GET,value = "/society/{id}/tower")
    public List<TowerResponse> findAllByName(@PathVariable long id)
    {

        return services.findAllById(id);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/society/{id}/tower/{tower_id}")
    public TowerResponse findById(@PathVariable long id,@PathVariable long tower_id)
    {
        return services.findById(id,tower_id);
    }

    // update
    @RequestMapping(method = RequestMethod.PUT,value="/society/{id}/updateTower")
    public void updateTower(@PathVariable long id,@RequestBody RestRequest<TowerTO> tower)
    {
         services.updateTower(id,tower.getRequestObject());
    }

    //delete
    @RequestMapping(method = RequestMethod.DELETE,value="/society/{id}/deleteTower")
    public void deleteTower(@RequestBody RestRequest<TowerTO> tower)
    {
        services.deleteTower(tower.getRequestObject());
    }

}
