package com.justintime.jit.repository;

import com.justintime.jit.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDateTime;

@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {

    // Find orders by customer ID
    List<Order> findByCustomerId(Long customerId);

    // Find all orders for a specific restaurant
    List<Order> findByRestaurantId(Long restaurantId);

    // Find orders by status
    List<Order> findByStatus(String status);

    // Get orders within a time range
    List<Order> findByOrderTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
}
