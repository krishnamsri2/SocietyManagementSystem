package com.example.ProjectLatest.Security;

import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.service.LoginService;
import com.example.ProjectLatest.to.LoginTO;
import com.example.ProjectLatest.to.RestRequest;
import com.example.ProjectLatest.to.Token;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class Interceptor implements HandlerInterceptor {

    public static HashMap<Long,Token> hashMemory = new HashMap<>();

    @Autowired
    private LoginService service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equalsIgnoreCase("POST")) {

            String q = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            ObjectMapper m = new ObjectMapper();
            RestRequest<LoginTO> tempLogin = m.readValue(q,new TypeReference<RestRequest<LoginTO>>() {});

            String emailId = tempLogin.getRequestObject().getEmailId();
            String password = tempLogin.getRequestObject().getPassword();
            User user = service.verifyUser(emailId,password);

            if(user != null){
                return true;
            }else{
                return false;
            }
        }

  return true;
    }

}
