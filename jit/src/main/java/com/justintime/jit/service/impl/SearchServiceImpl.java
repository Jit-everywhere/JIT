package com.justintime.jit.service.impl;

import com.justintime.jit.dto.SearchResultDto;
import com.justintime.jit.entity.Food;
import com.justintime.jit.entity.Restaurant;
import com.justintime.jit.repository.FoodRepository;
import com.justintime.jit.repository.RestaurantRepository;
import com.justintime.jit.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<SearchResultDto> searchByName(String query) {
        List<SearchResultDto> results = new ArrayList<>();

        // Search Restaurants
        List<Restaurant> matchingRestaurants = restaurantRepository.findByRestaurantNameContaining(query);
        for (Restaurant restaurant : matchingRestaurants) {
            SearchResultDto dto = new SearchResultDto();
            dto.setType("Restaurant");
            dto.setName(restaurant.getRestaurantName());

            // Get associated foods
            List<String> foods = new ArrayList<>();
            restaurant.getMenu().forEach(food -> foods.add(food.getFood().getFoodName()));
            dto.setAssociatedNames(foods);

            results.add(dto);
        }

        // Search Foods
        List<Food> matchingFoods = foodRepository.findByFoodNameContaining(query);
        for (Food food : matchingFoods) {
            SearchResultDto dto = new SearchResultDto();
            dto.setType("Food");
            dto.setName(food.getFoodName());

            // Get associated restaurants
            List<String> restaurants = new ArrayList<>();
            restaurants.add(food.getFoodName());
            dto.setAssociatedNames(restaurants);

            results.add(dto);
        }

        return results;
    }
}
