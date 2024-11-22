package com.justintime.jit.controller;

import com.justintime.jit.entity.User;
import com.justintime.jit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        // Logic to handle registration
        userService.save(user); // Convert DTO to entity
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        // Logic to handle login
        // Add login authentication logic
        return ResponseEntity.ok("Login successful");
    }
}
