

package com.sisal.user_services.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sisal.user_services.dto.UserDTO;
import com.sisal.user_services.model.User;
import com.sisal.user_services.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author senturke
 */
@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public User registerUser(UserDTO userDTO){
        log.info("Attempting to register user");
        Optional<User> existingUser = userRepository.findByUserEmail(userDTO.getUserEmail());
        if(existingUser.isPresent()){
            log.warn("Email address is already in use");
            throw new RuntimeException("Email address is already in use.");
        }
        
        User user = new User();
        user.setName(userDTO.getUserName());
        user.setUserSurname(userDTO.getUserSurname());
        user.setUserBirthDate(userDTO.getUserBirthDate());
        user.setUserCountryOfBirth(userDTO.getUserCountryOfBirth());
        user.setUserEmail(userDTO.getUserEmail());
        user.setUserPassword(userDTO.getUserPassword());

        return userRepository.save(user);
    }
}
