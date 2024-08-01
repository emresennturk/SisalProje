package com.sisal.user_services.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sisal.user_services.dto.UserSummaryDTO;
import com.sisal.user_services.model.User;
import com.sisal.user_services.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserEmail(username).orElseThrow();
    }

    public UserSummaryDTO getUsers() {
       UserSummaryDTO sumDto = new UserSummaryDTO(null, null, null);
        
            List<User> result = userRepository.findAll();
            if (!result.isEmpty()) {
                log.info("Successful");
            } else {
                throw new RuntimeException("No user found");
            }
            return sumDto;
       
    }
    
}
