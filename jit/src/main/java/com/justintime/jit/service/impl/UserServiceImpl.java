package com.justintime.jit.service.impl;

import com.justintime.jit.entity.Enums.Role;
import com.justintime.jit.entity.User;
import com.justintime.jit.repository.UserRepository;
import com.justintime.jit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Category not found with id " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public User update(Long id, User updatedUser) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setProfilePictureUrl(updatedUser.getProfilePictureUrl());
            existingUser.setIsActive(updatedUser.getIsActive());
            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
            existingUser.setPasswordHash(updatedUser.getPasswordHash());
            existingUser.setRole(updatedUser.getRole());
            existingUser.setUpdatedDttm(LocalDateTime.now()); // Set updated timestamp
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Override
    public List<User> findByRole(Role role) {
        return userRepository.findByRole(role);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
