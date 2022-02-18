package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.response.SocietyResponse;
import com.example.ProjectLatest.to.SocietyTO;
import com.example.ProjectLatest.entity.Society;
import com.example.ProjectLatest.service.SocietyService;
import com.example.ProjectLatest.to.RestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocietyController {
    @Autowired
    private SocietyService societyService;

    // Post request to add society
    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(method = RequestMethod.POST,value = "/addSociety")
    public void addSociety(@RequestBody RestRequest<SocietyTO> restRequest)
    {
         societyService.saveSociety(restRequest.getRequestObject(),restRequest.getToken());
    }

    // get all notice
    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(method = RequestMethod.GET,value="/societies")
    public List<SocietyResponse> findAllSociety()
    {
        return societyService.getSociety();
    }

    // get society by id
    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(method = RequestMethod.GET,value="/society/{id}")
    public SocietyResponse findById(@PathVariable long id)
    {
        return societyService.getSocietyId(id);
    }
    // update
    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(method = RequestMethod.PUT,value = "/society/updates/{id}")
    public void updateSociety(@PathVariable long id, @RequestBody RestRequest<SocietyTO> society)
    {
        societyService.updateSociety(id,society.getRequestObject());
    }

    // delete
    @RequestMapping(method = RequestMethod.DELETE,value = "/society/delete/{id}")
    public String deleteSociety(@PathVariable long id)
    {
        return societyService.deleteSociety(id);
    }
}
