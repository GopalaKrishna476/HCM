package com.hcm.service;

import com.hcm.entity.UserLeavesEntity;
import com.hcm.enums.SubmitType;
import com.hcm.pojo.RequestTimeOffPojo;
import com.hcm.repository.UserLeavesRepository;
import com.hcm.response.HCMResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class HCMService {

    @Autowired
    ConversionService conversionService;

    @Autowired
    UserLeavesRepository userLeavesRepository;

    public HCMResponse requestTimeOff(Long userId, RequestTimeOffPojo requestTimeOffPojo) throws SQLException {
        // request for time off
        HCMResponse hcmResponse = new HCMResponse();
        Long existingLeaves = 0L;
        UserLeavesEntity userLeavesEntityDb = userLeavesRepository.findByUserId(userId);
        if(userLeavesEntityDb != null){
            existingLeaves = userLeavesEntityDb.getNoOfLeaves();
        }else{
            hcmResponse.setCode(400L);
            hcmResponse.setMessage("User Not Found");
        }
        UserLeavesEntity userLeavesEntity = conversionService.populateUserLeavesEntity(userId, requestTimeOffPojo, existingLeaves);
        userLeavesRepository.save(userLeavesEntity);
        hcmResponse.setCode(200L);
        hcmResponse.setMessage("Success");
        return hcmResponse;
    }

    public void getLeaveInfo(Long userId){

    }
}
