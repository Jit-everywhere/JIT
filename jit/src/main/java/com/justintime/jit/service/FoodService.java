package com.justintime.jit.service;

import com.justintime.jit.entity.Food;

import java.util.List;

public interface FoodService extends BaseService<Food, Long> {
    List<Food> findByRestaurantsId(Long restaurantId);
    List<Food> findByNameContaining(String name);
}
