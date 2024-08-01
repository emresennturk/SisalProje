package com.sisal.user_services.model;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author senturke
 */
@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @NotNull(message="Name cannot be null")
    private String name;

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

    private String role;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return null;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        
        return userPassword;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return userEmail;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
