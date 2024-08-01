package com.sisal.user_services.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sisal.user_services.dto.UserSummaryDTO;
import com.sisal.user_services.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/getUsers")
    public List<UserSummaryDTO> getUsers() {
        return userRepository.findAll().stream()
            .map(user ->new UserSummaryDTO(user.getUserId(), user.getUserEmail(), null))
            .collect(Collectors.toList());
    }

}
