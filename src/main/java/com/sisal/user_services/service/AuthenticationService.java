package com.sisal.user_services.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sisal.user_services.dto.LoginDTO;
import com.sisal.user_services.model.User;
import com.sisal.user_services.repository.UserRepository;
import com.sisal.user_services.utility.JwtUtil;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthenticationService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;     
    }
    
   @Transactional
   public String authenticateUser(LoginDTO loginDTO) {
    log.info("Attempting to authenticate user with email");
    Optional<User> existingUser = userRepository.findByUserEmail(loginDTO.getEmail());
    if (existingUser.isPresent()) {
        User foundUser = existingUser.get();
        log.info("User found with email");
        if (foundUser.getUserPassword().equals(loginDTO.getPassword())) {
            return jwtUtil.generateToken(foundUser.getUserEmail());
        }else {
            throw new RuntimeException("Invalid password");
        }
        } else {
        throw new RuntimeException("User not found");
        }
    }
}
