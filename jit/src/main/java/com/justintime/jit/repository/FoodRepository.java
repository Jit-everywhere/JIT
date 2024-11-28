package com.justintime.jit.repository;

import com.justintime.jit.entity.Food;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends BaseRepository<Food, Long> {

    List<Food> findByRestaurantsId(Long restaurantId);

    // Search food by name
    List<Food> findByNameContaining(String name);

}
