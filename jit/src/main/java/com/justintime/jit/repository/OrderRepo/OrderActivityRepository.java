package com.justintime.jit.repository.OrderRepo;

import com.justintime.jit.entity.OrderEntities.OrderActivity;
import com.justintime.jit.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderActivityRepository extends BaseRepository<OrderActivity, Long> {
}
