package com.justintime.jit.repository;

import com.justintime.jit.entity.OrderEntities.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends BaseRepository<OrderItem,Long> {
}
