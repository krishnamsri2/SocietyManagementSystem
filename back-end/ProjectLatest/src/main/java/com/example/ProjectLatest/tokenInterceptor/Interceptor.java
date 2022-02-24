package com.example.ProjectLatest.tokenInterceptor;

import com.example.ProjectLatest.to.Token;

import java.util.HashMap;

public class Interceptor {
    HashMap<String, Token> inMemoryDB = new HashMap<>();

    public void addInMemoryDB(String emailId,Token token) {
        inMemoryDB.put(emailId,token);
    }

    public Token getInMemoryDB(String emailId){
        return inMemoryDB.get(emailId);
    }

    public void deleteInMemoryDB(String emailId){
        inMemoryDB.remove(emailId);
    }



}
