package com.sisal.user_services.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author senturke
 */

@Getter
@Setter
public class UserDTO {
    
    @NotNull(message="Name cannot be null")
    private String userName;

    
    @NotNull(message="Surname cannot be null")
    private String userSurname;

    
    @NotNull(message="Birth date cannot be null")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date userBirthDate;

    
    @NotNull(message="Country cannot be null")
    private String userCountryOfBirth;
    
   
    @NotNull(message="Email cannot be null")
    @Email(message="Email shoul be valid")
    private String userEmail;

    
    @NotNull(message="Password cannot be null")
    @Min(value=8, message="Password should not be less then 8")
    private String userPassword;
}
