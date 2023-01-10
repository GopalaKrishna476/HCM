package com.hcm.controller;

import com.hcm.pojo.RequestTimeOffPojo;
import com.hcm.response.HCMResponse;
import com.hcm.service.HCMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class HCMController {

    @Autowired
    HCMService hcmService;

    @PostMapping(value = "/requestTimeOff/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HCMResponse requestTimeOff(@PathVariable Long userId, RequestTimeOffPojo requestTimeOffPojo) throws SQLException {
        return hcmService.requestTimeOff(userId, requestTimeOffPojo);
    }

    @GetMapping(value = "/leaveInfo/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void getLeaveInfo(@PathVariable Long userId) throws SQLException {
        return hcmService.getLeaveInfo(userId);
    }
}
