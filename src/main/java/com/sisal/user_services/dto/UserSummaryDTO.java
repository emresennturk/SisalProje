package com.sisal.user_services.dto;

import java.util.List;
import java.util.UUID;

import com.sisal.user_services.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserSummaryDTO {

    private UUID userId;
    private String userEmail;
    private List<User> UserList;
}
