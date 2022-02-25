package com.example.ProjectLatest.Security;

import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.service.LoginService;
import com.example.ProjectLatest.to.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Interceptor implements HandlerInterceptor {

    static ConcurrentHashMap<Long, Token> hashMemory = new ConcurrentHashMap<>();

    @Autowired
    private LoginService service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equalsIgnoreCase("POST")) {

            Scanner s = null;
            try {
                s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
            } catch (IOException e) {
                e.printStackTrace();
            }
            String p =  s.hasNext() ? s.next() : "";

            System.out.println(p);

            String emailId = request.getParameter("emailId");
            String password = request.getParameter("password");
            User user = service.verifyUser(emailId,password);

            if(user != null){
                Token token = new Token();
                token.setSocietyId(user.getSocietyId());
                token.setUserId(user.getUserId());

                hashMemory.put(user.getUserId(),token);
                return true;

            }else{
                return false;
            }

        }

        return true;
    }

}
