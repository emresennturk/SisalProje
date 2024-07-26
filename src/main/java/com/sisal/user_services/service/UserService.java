

package com.sisal.user_services.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sisal.user_services.model.User;
import com.sisal.user_services.repository.UserRepository;

/**
 *
 * @author senturke
 */
@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(User user){
        Optional<User> existingUser = userRepository.findByUserEmail(user.getUserEmail());
        if(existingUser.isPresent()){
            throw new RuntimeException("Email address is already in use.");
        }
        user.setUserId(UUID.randomUUID());
        return userRepository.save(user);
    }

}
