package com.justintime.jit.service.impl;

import com.justintime.jit.entity.Food;
import com.justintime.jit.repository.FoodRepository;
import com.justintime.jit.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl extends BaseServiceImpl<Food, Long> implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Food> findByRestaurantId(Long restaurantId) {
        return foodRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public List<Food> findByNameContaining(String name) {
        return foodRepository.findByNameContaining(name);
    }
}
