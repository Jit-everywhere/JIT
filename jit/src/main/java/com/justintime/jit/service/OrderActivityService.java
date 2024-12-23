package com.justintime.jit.service;

import com.justintime.jit.entity.OrderEntities.OrderActivity;

import java.util.List;
import java.util.Optional;

public interface OrderActivityService {
    List<OrderActivity> getAllOrderActivities();
    OrderActivity createOrderActivity(OrderActivity orderActivity);
    Optional<OrderActivity> getOrderActivityById(Long id);
    void deleteOrderActivity(Long id);
}
