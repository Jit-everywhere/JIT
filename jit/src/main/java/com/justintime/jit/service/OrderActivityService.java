package com.justintime.jit.service;

import com.justintime.jit.entity.OrderEntities.OrderActivity;

import java.util.List;
import java.util.Optional;

public interface OrderActivityService {
    List<OrderActivity> getAllOrderActivities();
    Optional<OrderActivity> getOrderActivityById(Long id);
    OrderActivity updateOrderActivity(Long id, OrderActivity orderActivityDetails);
    OrderActivity saveOrderActivity(OrderActivity orderActivity);
    void deleteOrderActivity(Long id);
}
