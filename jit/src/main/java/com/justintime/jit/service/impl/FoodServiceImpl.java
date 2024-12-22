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
        public List<Food> getAllFoods() {
            return foodRepository.findAll();
        }

        @Override
        public Food getFoodById(Long id) {
            return foodRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Food not found with id: " + id));
        }

        @Override
        public Food createFood(Food food) {
            return foodRepository.save(food);
        }

        @Override
        public Food updateFood(Long id, Food foodDetails) {
            return foodRepository.findById(id)
                    .map(food -> {
                        food.setFoodName(foodDetails.getFoodName());
                        food.setDescription(foodDetails.getDescription());
                        food.setCategory(foodDetails.getCategory());
                        food.setUpdatedDttm(foodDetails.getUpdatedDttm());
                        return foodRepository.save(food);
                    }).orElseThrow(() -> new RuntimeException("Food not found with id: " + id));
        }

        @Override
        public void deleteFood(Long id) {
            Food food = foodRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Food not found with id: " + id));
            foodRepository.delete(food);
        }

}
