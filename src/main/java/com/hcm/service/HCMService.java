package com.hcm.service;

import com.hcm.entity.LeaveRequestEntity;
import com.hcm.enums.LeaveType;
import com.hcm.exception.ApiException;
import com.hcm.repository.UserLeavesRepository;
import com.hcm.response.UserLeaveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HCMService {

    @Autowired
    ConversionService conversionService;

    @Autowired
    UserLeavesRepository userLeavesRepository;

    public List<UserLeaveResponse> getLeaveInfo(Long userId) throws ApiException {
        if(userId != null){
            List<LeaveRequestEntity> leaveRequestEntityList = userLeavesRepository.findLeaveRequestByUserId(userId);
            if(leaveRequestEntityList != null && !leaveRequestEntityList.isEmpty()){
                Map<LeaveType, Long> leaveMap = leaveRequestEntityList.stream()
                        .collect(Collectors.groupingBy(LeaveRequestEntity::getLeaveType, Collectors.counting()));
                return conversionService.populateUserLeaveResponse(leaveMap);
            }else{
                throw new ApiException("User Not Found");
            }
        }else{
            throw new ApiException("User Id is null");
        }
    }
}
