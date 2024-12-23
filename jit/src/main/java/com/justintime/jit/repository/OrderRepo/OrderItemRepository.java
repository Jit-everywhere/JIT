package com.justintime.jit.repository.OrderRepo;

import com.justintime.jit.entity.OrderEntities.OrderItem;
import com.justintime.jit.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends BaseRepository<OrderItem,Long> {
}
