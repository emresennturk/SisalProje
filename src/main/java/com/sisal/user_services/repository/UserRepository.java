package com.sisal.user_services.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisal.user_services.model.User;

/**
 *
 * @author senturke
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    Optional<User> findByUserEmail(String userEmail);


}
