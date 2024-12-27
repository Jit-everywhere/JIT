package com.justintime.jit.service;

import com.justintime.jit.entity.Enums.Role;
import com.justintime.jit.entity.User;

import java.util.List;

public interface UserService extends BaseService<User, Long> {
    List<User> findByRole(Role role);
    User findByEmail(String email);
    List<User> findByUserName(String userName);

    void delete(Long id);

    User update(Long id, User user);
}
