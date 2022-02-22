package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.response.FlatResponse;
import com.example.ProjectLatest.service.FlatService;
import com.example.ProjectLatest.to.FlatTO;
import com.example.ProjectLatest.to.RestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FlatController {

    @Autowired
    private FlatService flatService;

    // add flat
    @RequestMapping(method = RequestMethod.POST,value="/society/{id}/tower/{tower_id}/addFlat")
    public void addTower(@RequestBody RestRequest<FlatTO> flatTo,@PathVariable long tower_id)
    {
        flatService.addFlat(flatTo.getRequestObject(),tower_id,flatTo.getToken());
    }
    // get request to get all flat
    @RequestMapping(method = RequestMethod.GET,value = "/society/{id}/tower/{tower_id}/flat")
    public List<FlatResponse> getAll(@PathVariable long tower_id)
    {
        return flatService.getAll(tower_id);
    }

    // get request to all available flat
    @RequestMapping(method = RequestMethod.GET,value = "/society/{id}/tower/{tower_id}/flatAvailable")
    public List<FlatResponse> getAllAvailable(@PathVariable long tower_id)
    {
        return flatService.getAllAvailable(tower_id);
    }
    // by particular id
    @RequestMapping(method = RequestMethod.GET,value = "/society/{id}/tower/{tower_id}/flat/{flat_id}")
    public FlatResponse getById(@PathVariable long flat_id)
    {
        return flatService.getById(flat_id);
    }
    // update flat status
    // update number of occupants
    @RequestMapping(method =RequestMethod.PUT,value = "/society/{id}/tower/{tower_id}/flat/{flat_id}/updateStatus")
    public void  updateStatus(@PathVariable long flat_id,@RequestBody RestRequest<FlatTO> flatTo)
    {
        flatService.updateStatus(flat_id,flatTo.getRequestObject());
        return;
    }

    @RequestMapping(method =RequestMethod.PUT,value = "/society/{id}/tower/{tower_id}/flat/{flat_id}/updateOccupant")
    public void  updateOccupant(@PathVariable long flat_id,@RequestBody RestRequest<FlatTO> flatTo)
    {
        flatService.updateOccupant(flat_id,flatTo.getRequestObject());
        return;
    }
    // delete
    @RequestMapping(method=RequestMethod.DELETE,value="/society/{id}/tower/{tower_id}/flat/{flat_id}/delete")
    public void removeFlat(@PathVariable long flat_id)
    {
        flatService.removeFlat(flat_id);
    }

}
