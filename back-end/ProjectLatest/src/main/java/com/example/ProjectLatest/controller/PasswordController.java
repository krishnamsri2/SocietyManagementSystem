// package com.example.ProjectLatest.controller;

// import com.example.ProjectLatest.service.PasswordService;
// import com.example.ProjectLatest.to.PasswordTO;
// import com.example.ProjectLatest.to.RestRequest;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;

// import javax.servlet.http.HttpServletRequest;

// @RestController
// public class PasswordController {

//     @Autowired
//     private PasswordService passwordService;

//     @RequestMapping(method = RequestMethod.POST,value = "/forgot")
//     public void forgotPassword(@RequestBody RestRequest<PasswordTO> restRequest, HttpServletRequest request)
//     {
//          passwordService.forgotPassword(restRequest.getRequestObject(),restRequest.getToken(),request);
//     }
// }
