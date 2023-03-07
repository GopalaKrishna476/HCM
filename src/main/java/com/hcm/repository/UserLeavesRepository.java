package com.hcm.repository;

import com.hcm.entity.LeaveRequestEntity;
import com.hcm.enums.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLeavesRepository extends JpaRepository<LeaveRequestEntity, Long> {

    @Query(value = "select * from LeaveRequest where lr_ui_id IN (?1)", nativeQuery = true)
    List<LeaveRequestEntity> findLeaveRequestByUserId(Long userId);

    List<LeaveRequestEntity> findByUserIdAndLeaveType(Long userId, LeaveType leaveType);
}
