package com.justintime.jit.service;

import com.justintime.jit.entity.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order updateOrderStatus(Long id, String status);
    void deleteOrder(Long id);
}
