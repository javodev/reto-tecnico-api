package com.tech.challenge.repository;

import com.tech.challenge.repository.entity.PhonesDao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PhoneRepository extends JpaRepository<PhonesDao, UUID> {
}