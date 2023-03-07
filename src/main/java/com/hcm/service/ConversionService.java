package com.hcm.service;

import com.hcm.config.ApplicationProperties;
import com.hcm.enums.LeaveType;
import com.hcm.response.UserLeaveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ConversionService {

    @Autowired
    ApplicationProperties applicationProperties;

    public List<UserLeaveResponse> populateUserLeaveResponse(Map<LeaveType, Long> leaveMap){

        List<UserLeaveResponse> userLeaveResponseList = new ArrayList<>();
        for(Map.Entry<LeaveType, Long> leave : leaveMap.entrySet()) {
            UserLeaveResponse userLeaveResponse = new UserLeaveResponse();
            userLeaveResponse.setLeaveType(leave.getKey());
            userLeaveResponse.setRemainingLeaves(populateRemainingLeavesCount(leave.getKey(), leave.getValue()));
            userLeaveResponse.setAnnualLeaves(populateAnnualLeavesCount(leave.getKey()));
            userLeaveResponseList.add(userLeaveResponse);
        }

        return userLeaveResponseList;
    }

    private Long populateRemainingLeavesCount(LeaveType leaveType, Long remainingLeaves){
        long remainingLeaveCount = 0L;
        switch (leaveType){
            case EARNED_LEAVE:
                remainingLeaveCount = applicationProperties.getEarnedLeaveCount() - remainingLeaves;
                break;
            case SICK_LEAVE:
                remainingLeaveCount = applicationProperties.getSickLeaveCount() - remainingLeaves;
                break;
            case CASUAL_LEAVE:
                remainingLeaveCount = applicationProperties.getCasualLeaveCount() - remainingLeaves;
                break;
            default:
                break;
        }
        return remainingLeaveCount;
    }

    private Long populateAnnualLeavesCount(LeaveType leaveType){
        long annualLeaveCount = 0L;
        switch (leaveType){
            case EARNED_LEAVE:
                annualLeaveCount = applicationProperties.getEarnedLeaveCount();
                break;
            case SICK_LEAVE:
                annualLeaveCount = applicationProperties.getSickLeaveCount();
                break;
            case CASUAL_LEAVE:
                annualLeaveCount = applicationProperties.getCasualLeaveCount();
                break;
            default:
                break;
        }
        return annualLeaveCount;
    }
}
