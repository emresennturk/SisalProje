package com.sisal.user_services.model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author senturke
 */
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID userId;

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

    public User(){}

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public Date getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(Date userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getUserCountryOfBirth() {
        return userCountryOfBirth;
    }

    public void setUserCountryOfBirth(String userCountryOfBirth) {
        this.userCountryOfBirth = userCountryOfBirth;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    

    

    

}
