package com.tech.challenge.business.impl;

import com.tech.challenge.business.UserService;
import com.tech.challenge.expose.dto.ErrorResponse;
import com.tech.challenge.expose.dto.UserDetailResponse;
import com.tech.challenge.expose.dto.UserRequest;
import com.tech.challenge.repository.PhoneRepository;
import com.tech.challenge.repository.UserInfoRepository;
import com.tech.challenge.repository.UserRepository;
import com.tech.challenge.repository.entity.PhonesDao;
import com.tech.challenge.repository.entity.UserDao;
import com.tech.challenge.repository.entity.UserInfoDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public final class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;
    private final PhoneRepository phonesRepository;

    @Override
    public ResponseEntity<?> createUser(UserRequest userRequest) {

        if(userInfoRepository.existsByEmail(userRequest.getEmail())){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ErrorResponse("El email ya está registrado"));
        }else{
            UserDao newUser = associateDataUser(userRequest);
            return ResponseEntity.ok(UserDetailResponse.getUserDetailFromUserDao(newUser, ""));
        }
    }

    public UserDao associateDataUser(UserRequest userRequest) {

        UserDao savedUser = UserDao.createNewUser();
        userRepository.save(savedUser);

        UserInfoDao userInfoDao = UserInfoDao.associateUser(savedUser, userRequest.getName(), userRequest.getEmail(),
                userRequest.getEmail());
        userInfoRepository.save(userInfoDao);

        userRequest.getPhones().forEach(phoneRequest -> {
            PhonesDao phonesDao = PhonesDao.AssociateUserToPhones(userInfoDao, phoneRequest.getNumber(),
                    phoneRequest.getCitycode(), phoneRequest.getCountrycode());
            phonesRepository.save(phonesDao);
        });

        return savedUser;

    }
}
