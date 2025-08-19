package com.LangLearner.services;
import com.LangLearner.entities.User;
import com.LangLearner.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;

    public UserServiceImpl(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

@Override
public User registerUser(User user) {
    // ✅ Check if username already exists
    if (userRepository.existsByUsername(user.getUsername())) {
        throw new RuntimeException("Username already exists!");
    }

    // ✅ Set default role if none provided
    if (user.getRole() == null || user.getRole().isBlank()) {
        user.setRole("USER");
    }

    return userRepository.save(user);
}
    @Override
    public User login(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password)) // simple password check (later use hashing)
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}

