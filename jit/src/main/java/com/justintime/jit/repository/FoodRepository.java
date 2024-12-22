package com.justintime.jit.repository;

import com.justintime.jit.entity.Food;
import com.justintime.jit.entity.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends BaseRepository<Food, Long> {
    List<Food> findByFoodNameContaining(String restaurantName);

}
