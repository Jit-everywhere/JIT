package com.justintime.jit.repository;

import com.justintime.jit.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    // Find all users by role
    List<User> findByRole(String role);

    // Find users connected to a specific restaurant
    List<User> findByRestaurantId(Long restaurantId);

    // Find a user by email
    User findByEmail(String email);
}
