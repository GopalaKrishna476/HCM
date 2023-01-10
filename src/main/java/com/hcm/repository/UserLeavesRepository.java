package com.hcm.repository;

import com.hcm.entity.UserLeavesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLeavesRepository extends JpaRepository<UserLeavesEntity, Long> {

    UserLeavesEntity findByUserId(Long userId);
}
