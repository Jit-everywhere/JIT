package com.justintime.jit.repository;

import com.justintime.jit.entity.Food;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends BaseRepository<Food, Long> {

    // Find all food items in a restaurant
    List<Food> findByRestaurantId(Long restaurantId);

    // Search food by name
    List<Food> findByNameContaining(String name);
}
