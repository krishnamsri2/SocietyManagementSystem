package com.example.ProjectLatest.service;

import com.example.ProjectLatest.response.SocietyResponse;
import com.example.ProjectLatest.to.SocietyTO;
import com.example.ProjectLatest.entity.Society;
import com.example.ProjectLatest.repository.SocietyRepository;
import com.example.ProjectLatest.to.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocietyService {

    @Autowired
    private SocietyRepository repository;

    public void saveSociety(SocietyTO society, Token token) {

     try {
         Society soc = new Society(society.getSocietyName(), token.getUserId(), false, true);
         repository.save(soc);
     }
     catch (Exception e)
     {
         e.printStackTrace();
     }
    }
    // get request for all society
    public List<SocietyResponse> getSociety() {
        List<Society> society = new ArrayList<>();
        List<SocietyResponse> copy=null;
        try {

            repository.findAll();
             copy = society.stream()
                    .map(Society -> new SocietyResponse(Society.getSocietyNameame(), Society.getCreatedby(), Society.getCreated()))
                    .collect(Collectors.toList());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return copy;
    }
    // get request for particular society
    public SocietyResponse getSocietyId(long id) {
        Society temp=null;
        SocietyResponse societyResponse=null;
        try {
            temp = repository.findById(id).orElse(null);
            if(temp!=null && !temp.isDeleted())
            societyResponse = new SocietyResponse(temp.getSocietyNameame(), temp.getCreatedby(), temp.getCreated());
        }
        catch (Exception e)
        {
            e.printStackTrace();;
        }
        return  societyResponse;
    }

    public void updateSociety(long id, SocietyTO society) {

        try {
            Society existingSociety = repository.findById(id).orElse(null);
            if(existingSociety!=null && !existingSociety.isDeleted())
            existingSociety.setSocietyName(society.getSocietyName());

            repository.save(existingSociety);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String deleteSociety(long id) {
        try {
            Society temp = repository.findById(id).orElse(null);
            temp.setDeleted(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {

            return "Product Removed !!" + id;
        }
    }
}
