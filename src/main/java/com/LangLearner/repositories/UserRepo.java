package com.LangLearner.repositories;

import com.LangLearner.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    
    // Find user by username (useful for login)
    Optional<User> findByUsername(String username);

    // Check if username already exists
    boolean existsByUsername(String username);
}
