package com.hcm.response;

import com.hcm.enums.LeaveType;

public class UserLeaveResponse {

    private LeaveType leaveType;
    private Long remainingLeaves;
    private Long annualLeaves;

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public Long getRemainingLeaves() {
        return remainingLeaves;
    }

    public void setRemainingLeaves(Long remainingLeaves) {
        this.remainingLeaves = remainingLeaves;
    }

    public Long getAnnualLeaves() {
        return annualLeaves;
    }

    public void setAnnualLeaves(Long annualLeaves) {
        this.annualLeaves = annualLeaves;
    }
}
