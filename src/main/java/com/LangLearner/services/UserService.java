package com.LangLearner.services;

import com.LangLearner.entities.User;
import java.util.List;

public interface UserService {
    User registerUser(User user);         // Register new user
    User login(String username, String password);  // Validate login
    List<User> getAllUsers();             // List all users
    User getUserById(Long id);            // Find user by ID
}
