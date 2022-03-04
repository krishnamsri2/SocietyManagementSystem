package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.response.ChangePasswordResponse;
import com.example.ProjectLatest.service.ChangePasswordService;
import com.example.ProjectLatest.to.ChangePasswordTO;
import com.example.ProjectLatest.to.RestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ChangePasswordController {
    @Autowired
    private ChangePasswordService changePasswordService;

    // update to change password
    // post request to change password
    @RequestMapping(method = RequestMethod.PUT,value = "/changePassword")
    public ChangePasswordResponse updatePassword(@RequestBody RestRequest<ChangePasswordTO> restRequest)
    {
        return changePasswordService.updatePassword(restRequest.getRequestObject(),restRequest.getToken());
    }
}
