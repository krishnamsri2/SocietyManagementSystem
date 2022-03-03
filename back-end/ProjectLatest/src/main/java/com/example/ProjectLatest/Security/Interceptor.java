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
            if (url.contains("/login")||(url.contains("/forgot")||url.contains(("/reset")))) {
                isUser = true;
            } else {
                long userId = Long.parseLong(request.getHeader("userId"));
                long societyId = Long.parseLong(request.getHeader("societyId"));
                    isUser = service.verifyToken(userId, societyId);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
        return isUser;
    }
}
