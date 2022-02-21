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

        List<SocietyResponse> copy=null;
        try {
            List<Society> societies = repository.findAll();
            List<Society> society=new ArrayList<>();
            for(int i=0;i<societies.size();i++)
            {
                Society temp=societies.get(i);
                if(!temp.isDeleted())
                {
                    society.add(temp);
                }
            }
            if(society.size()!=0)
           copy = society.stream()
                    .map(Society -> new SocietyResponse(Society.getSocietyName(), Society.getCreatedby(), Society.getCreated(),Society.getSocietyid()))
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
            societyResponse = new SocietyResponse(temp.getSocietyName(), temp.getCreatedby(), temp.getCreated(), temp.getSocietyid());
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
        String ack="not removed";
        try {
            Society temp = repository.findById(id).orElse(null);
            if(temp!=null)
            {
                temp.setDeleted(true);
                repository.save(temp);
                ack="removed";
                repository.save(temp);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  ack;
    }
}
