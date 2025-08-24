package com.LangLearner.services.impl;

import com.LangLearner.entities.User;
import com.LangLearner.repositories.UserRepository;
import com.LangLearner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {

         if (user.getRole() == null || user.getRole().isEmpty()) {
        user.setRole("USER");
    }
    return userRepository.save(user);
        
        
    }

    @Override
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
}
