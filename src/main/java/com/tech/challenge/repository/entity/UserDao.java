package com.tech.challenge.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "users")
public class UserDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, updatable = false)
    private String created;

    @Column
    private String modified;

    @Column
    private String lastLogin;

    @Column
    private Boolean isActive;

    public static UserDao createNewUser() {
        UserDao userDao = new UserDao();
        userDao.setCreated(LocalDateTime.now().toString());
        userDao.setModified(null);
        userDao.setLastLogin(null);
        userDao.setIsActive(true);

        return userDao;
    }
}
