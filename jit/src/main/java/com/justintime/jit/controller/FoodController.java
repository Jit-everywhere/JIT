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

    @GetMapping("/{restaurantId}")
    public ResponseEntity<List<Food>> getFoodsByRestaurant(@PathVariable Long restaurantId) {
        List<Food> foods = foodService.findByRestaurantId(restaurantId);
        return ResponseEntity.ok(foods);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addFood(@RequestBody Food food) {
        foodService.save(food);  // Convert DTO to entity
        return ResponseEntity.ok("Food added successfully");
    }
}
