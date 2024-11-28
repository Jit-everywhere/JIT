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
    public List<Food> findByRestaurantsId(Long restaurantId) {
        // Get foods associated with the given restaurant ID
        return foodRepository.findByRestaurantsId(restaurantId);
    }

    @Override
    public List<Food> findByNameContaining(String name) {
        // Get foods that match the given name (partial match)
        return foodRepository.findByNameContaining(name);
    }

    // You can add more custom service methods if needed.
}
