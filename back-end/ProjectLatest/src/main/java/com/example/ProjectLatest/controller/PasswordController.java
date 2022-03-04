 package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.service.PasswordService;
import com.example.ProjectLatest.to.PasswordTO;
import com.example.ProjectLatest.to.RestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

 import javax.servlet.http.HttpServletRequest;

 @RestController
 @CrossOrigin(origins = "*")
 public class PasswordController {

     @Autowired
     private PasswordService passwordService;

    @RequestMapping(method = RequestMethod.POST,value = "/forgot")
    public void forgotPassword(@RequestBody RestRequest<PasswordTO> restRequest, HttpServletRequest request)
    {
         passwordService.forgotPassword(restRequest.getRequestObject(),request);
    }

    @RequestMapping(method = RequestMethod.POST,value="/reset")
    public void setNewPassword(@RequestBody RestRequest<PasswordTO> restRequest, RedirectAttributes redirectAttributes)
    {
        passwordService.setNewPassword(restRequest.getRequestObject(),redirectAttributes);
    }
}
