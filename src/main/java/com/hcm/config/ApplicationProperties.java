package com.hcm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"application.properties"})
public class ApplicationProperties {

    @Value("${sickLeaveCount:6}")
    private Long sickLeaveCount;

    @Value("${casualLeaveCount:6}")
    private Long casualLeaveCount;

    @Value("${earnedLeaveCount:10}")
    private Long earnedLeaveCount;

    public Long getSickLeaveCount() {
        return sickLeaveCount;
    }

    public void setSickLeaveCount(Long sickLeaveCount) {
        this.sickLeaveCount = sickLeaveCount;
    }

    public Long getCasualLeaveCount() {
        return casualLeaveCount;
    }

    public void setCasualLeaveCount(Long casualLeaveCount) {
        this.casualLeaveCount = casualLeaveCount;
    }

    public Long getEarnedLeaveCount() {
        return earnedLeaveCount;
    }

    public void setEarnedLeaveCount(Long earnedLeaveCount) {
        this.earnedLeaveCount = earnedLeaveCount;
    }
}
