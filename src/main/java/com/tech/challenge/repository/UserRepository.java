package com.tech.challenge.repository;

import com.tech.challenge.repository.entity.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserDao, UUID> {
}