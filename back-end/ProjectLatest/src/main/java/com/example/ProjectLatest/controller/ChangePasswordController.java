package com.example.ProjectLatest.controller;

import com.example.ProjectLatest.response.ChangePasswordResponse;
import com.example.ProjectLatest.service.ChangePasswordService;
import com.example.ProjectLatest.to.ChangePasswordTO;
import com.example.ProjectLatest.to.RestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChangePasswordController {
    @Autowired
    private ChangePasswordService changePasswordService;

    // update to change password
    // post request to change password
    @RequestMapping(method = RequestMethod.PUT,value = "/user/{user_id}/changePassword")
    public ChangePasswordResponse updatePassword(@PathVariable long user_id, @RequestBody RestRequest<ChangePasswordTO> restRequest)
    {
        return changePasswordService.updatePassword(user_id,restRequest.getRequestObject());
    }
}
