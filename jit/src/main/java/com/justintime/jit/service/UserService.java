package com.justintime.jit.service;

import com.justintime.jit.entity.User;

import java.util.List;

public interface UserService extends BaseService<User, Long> {
    List<User> findByRole(String role);
    User findByEmail(String email);
}
