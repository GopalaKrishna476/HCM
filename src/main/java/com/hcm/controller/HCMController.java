package com.hcm.controller;

import com.hcm.exception.ApiException;
import com.hcm.response.UserLeaveResponse;
import com.hcm.service.HCMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HCMController {

    @Autowired
    HCMService hcmService;

    @GetMapping(value = "/leaveInfo/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserLeaveResponse> getLeaveInfo(@PathVariable Long userId) throws ApiException {
        return hcmService.getLeaveInfo(userId);
    }
}
