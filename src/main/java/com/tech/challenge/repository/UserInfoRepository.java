package com.tech.challenge.repository;

import com.tech.challenge.repository.entity.UserInfoDao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserInfoRepository extends JpaRepository<UserInfoDao, UUID> {
    Boolean existsByEmail(String email);
    Boolean existsByEmailAndPassword(String email, String password);
}
