package com.justintime.jit.service;

import com.justintime.jit.entity.OrderEntities.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getAllOrderItems();
    OrderItem getOrderItemById(Long id);
    OrderItem saveOrderItem(OrderItem orderItem);
    void deleteOrderItem(Long id);
}
