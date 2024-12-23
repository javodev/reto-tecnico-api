package com.tech.challenge.expose.dto;

import com.tech.challenge.repository.entity.UserDao;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDetailResponse {

    private String id;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private Boolean isActive;

    public static UserDetailResponse getUserDetailFromUserDao(UserDao userDao, String token){
        UserDetailResponse response = new UserDetailResponse();

        response.setId(userDao.getId().toString());
        response.setCreated(LocalDateTime.parse(userDao.getCreated()));
        response.setModified(userDao.getModified() != null ? LocalDateTime.parse(userDao.getModified()) : null);
        response.setLastLogin(userDao.getLastLogin() != null ? LocalDateTime.parse(userDao.getLastLogin()) : null);
        response.setToken(token);
        response.setIsActive(userDao.getIsActive());

        return response;
    }
}
