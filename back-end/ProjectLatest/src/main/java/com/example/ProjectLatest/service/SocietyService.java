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

    public Society saveSociety(SocietyTO society, Token token) {

        Society soc=new Society(society.getSocietyName(), token.getUserId(), false,true);
        return repository.save(soc);
    }
    // get request for all society
    public List<SocietyResponse> getSociety() {
        List<Society> society=new ArrayList<>();
        repository.findAll();
        List<SocietyResponse> copy = society.stream()
                .map(Society-> new SocietyResponse(Society.getSocietyNameame(),Society.getCreatedby(),Society.getCreated()))
                .collect(Collectors.toList());
        return copy;
    }
    // get request for particular society
    public SocietyResponse getSocietyId(long id) {
        Society temp=repository.findById(id).orElse(null);
        SocietyResponse societyResponse=new SocietyResponse(temp.getSocietyNameame(),temp.getCreatedby(),temp.getCreated());
        return  societyResponse;
    }

    public Society updateSociety(long id, SocietyTO society) {

        Society existingSociety=repository.findById(id).orElse(null);
        existingSociety.setSocietyName(society.getSocietyName());

        return repository.save(existingSociety);
    }

    public String deleteSociety(long id) {
        Society temp=repository.findById(id).orElse(null);
        temp.setDeleted(true);
        return "Product Removed !!"+id;
    }
}
