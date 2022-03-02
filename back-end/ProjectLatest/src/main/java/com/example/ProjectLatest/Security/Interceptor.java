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
import java.util.stream.Collectors;

@Component
public class Interceptor implements HandlerInterceptor {

    public static HashMap<Long,Token> hashMemory = new HashMap<>();

    @Autowired
    private LoginService service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        Boolean isUser = false;

        try {
            if (url.indexOf("/login/") != -1) {
                String q = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
                ObjectMapper m = new ObjectMapper();
                RestRequest<LoginTO> tempLogin = m.readValue(q, new TypeReference<RestRequest<LoginTO>>() {
                });

                String emailId = tempLogin.getRequestObject().getEmailId();
                String password = tempLogin.getRequestObject().getPassword();
                System.out.println(emailId);
                System.out.println(password);
                System.out.println("preHandle1");
                User user = service.verifyUser(emailId, password);

                if (user != null) {
                    isUser =  true;
                }

            } else if(url.indexOf("/logout") != -1) {
                long userId = Long.parseLong(request.getHeader("userId"));
                long societyId = Long.parseLong(request.getHeader("societyId"));
                service.deleteToken(userId);
            }else{
                long userId = Long.parseLong(request.getHeader("userId"));
                long societyId = Long.parseLong(request.getHeader("societyId"));
                    isUser = service.verifyToken(userId, societyId);

                    if (isUser == false) {
                        System.out.println("Please LOGIN");
                    }
                }

        }catch (Exception e){
            e.printStackTrace();
        }
        return isUser;
    }
}
