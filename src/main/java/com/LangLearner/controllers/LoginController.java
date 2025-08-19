package com.LangLearner.controllers;

import com.LangLearner.entities.User;
import com.LangLearner.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")  // allow frontend React app
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    // ✅ Register a new user
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // ✅ Login (expects JSON { "username": "...", "password": "..." })
    @PostMapping("/login")
    public User login(@RequestBody User loginRequest) {
        return userService.login(loginRequest.getUsername(), loginRequest.getPassword());
    }

    // ✅ Get all users (admin use only)
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // ✅ Get user by ID
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
