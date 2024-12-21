package com.justintime.jit.controller;

import com.justintime.jit.entity.Food;
import com.justintime.jit.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

        @Autowired
        private FoodService foodService;

        @GetMapping
        public List<Food> getAllFoods() {
            return foodService.getAllFoods();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
            Food food = foodService.getFoodById(id);
            return ResponseEntity.ok(food);
        }

        @PostMapping
        public Food createFood(@RequestBody Food food) {
            return foodService.createFood(food);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Food> updateFood(@PathVariable Long id, @RequestBody Food foodDetails) {
            Food updatedFood = foodService.updateFood(id, foodDetails);
            return ResponseEntity.ok(updatedFood);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
            foodService.deleteFood(id);
            return ResponseEntity.noContent().build();
        }


}
