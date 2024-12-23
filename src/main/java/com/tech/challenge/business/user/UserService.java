package com.tech.challenge.business.user;

import com.tech.challenge.expose.dto.UserRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> createUser(UserRequest request);
}