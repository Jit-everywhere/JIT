package com.justintime.jit.repository;


import com.justintime.jit.entity.ShiftCapacity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftCapacityRepository extends JpaRepository<ShiftCapacity, Long> {
    List<ShiftCapacity> findByRestaurantId(Long restaurantId);
}

