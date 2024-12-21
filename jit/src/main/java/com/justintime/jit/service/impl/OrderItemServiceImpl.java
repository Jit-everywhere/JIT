package com.justintime.jit.service.impl;

import com.justintime.jit.entity.OrderEntities.OrderItem;
import com.justintime.jit.repository.OrderItemRepository;
import com.justintime.jit.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem,Long> implements OrderItemService {

        @Autowired
        private OrderItemRepository orderItemRepository;

        public List<OrderItem> getAllOrderItems() {
            return orderItemRepository.findAll();
        }

        public OrderItem getOrderItemById(Long id) {
            return orderItemRepository.findById(id).orElse(null);
        }

        public OrderItem saveOrderItem(OrderItem orderItem) {
            return orderItemRepository.save(orderItem);
        }

        public void deleteOrderItem(Long id) {
            orderItemRepository.deleteById(id);
        }

}
