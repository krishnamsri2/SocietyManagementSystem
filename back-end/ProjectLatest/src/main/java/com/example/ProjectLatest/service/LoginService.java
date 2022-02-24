package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.repository.UserRepository;
import com.example.ProjectLatest.to.LoginTO;
import com.example.ProjectLatest.to.Token;
import com.example.ProjectLatest.tokenInterceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends Interceptor {
    @Autowired
    private UserRepository repository;


    public void verifyUser(LoginTO requestObject, Token token) {
        try{
            User user = repository.findByEmailId(requestObject.getEmailId()).orElse(null);
            if(user == null){
                throw new NullPointerException();
            }else if(user.getIsDeleted() == true){
                throw new Exception("User Not Found");
            }else if(requestObject.getPassword().equals(user.getPassword())){
                if(getInMemoryDB(user.getEmailId()) != null){
                    throw new Exception("Already login ");
                }else{
                    addInMemoryDB(user.getEmailId(),token);
                    //System.out.println(user.getUserId()+ "\n" +getInMemoryDB(user.getEmailId()).getSocietyId());



                }
            }else{
                throw new Exception("Credentials Incorrect");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
