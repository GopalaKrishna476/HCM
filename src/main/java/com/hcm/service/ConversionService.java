package com.hcm.service;

import com.hcm.entity.UserInfoEntity;
import com.hcm.entity.UserLeavesEntity;
import com.hcm.enums.SubmitType;
import com.hcm.pojo.RequestTimeOffPojo;
import com.hcm.repository.UserLeavesRepository;
import com.hcm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class ConversionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLeavesRepository userLeavesRepository;

    public UserLeavesEntity populateUserLeavesEntity(Long userId, RequestTimeOffPojo requestTimeOffPojo, Long existingLeaves) throws SQLException {
        UserLeavesEntity userLeavesEntity = new UserLeavesEntity();
        userLeavesEntity.setUserId(userId);
        if(existingLeaves != 0 && requestTimeOffPojo.getSubmitType().equals(SubmitType.SUBMIT)){
            userLeavesEntity.setNoOfLeaves(existingLeaves + 1);
        }else {
            userLeavesEntity.setNoOfLeaves(existingLeaves);
        }
        userLeavesEntity.setLeaveType(requestTimeOffPojo.getLeaveType());
        userLeavesEntity.setReason(requestTimeOffPojo.getReason());
        userLeavesEntity.setDocumentLink(requestTimeOffPojo.getAttachments());
        return userLeavesEntity;
    }
}
