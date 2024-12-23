package com.tech.challenge.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "user_info")
public class UserInfoDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDao user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public static UserInfoDao associateUser(UserDao user, String name, String email, String password){
        UserInfoDao userInfoDao = new UserInfoDao();
        userInfoDao.setUser(user);
        userInfoDao.setName(name);
        userInfoDao.setEmail(email);
        userInfoDao.setPassword(password);

        return userInfoDao;
    }
}
