package com.sisal.user_services.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author senturke
 */
@Getter
@Setter
public class LoginDTO {

@NotNull(message="Email cannot be null")
    private String email;

@NotNull(message="Password cannot be null")
    private String password;
}
