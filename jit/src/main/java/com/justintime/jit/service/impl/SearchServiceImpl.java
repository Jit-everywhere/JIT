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
import java.util.Comparator;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    private static final double EARTH_RADIUS = 6371; // Radius of Earth in kilometers

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<SearchResultDto> searchByName(String query, double userLatitude, double userLongitude) {
        List<SearchResultDto> results = new ArrayList<>();

        // Search Restaurants
        List<Restaurant> matchingRestaurants = restaurantRepository.findByNameContaining(query);
        for (Restaurant restaurant : matchingRestaurants) {
            double distance = calculateDistance(userLatitude, userLongitude, restaurant.getLatitude(), restaurant.getLongitude());

            SearchResultDto dto = new SearchResultDto();
            dto.setType("Restaurant");
            dto.setName(restaurant.getName());
            dto.setDistance(distance);  // Set distance in km

            // Get associated foods
            List<String> foods = new ArrayList<>();
            restaurant.getMenu().forEach(food -> foods.add(food.getName()));
            dto.setAssociatedNames(foods);

            results.add(dto);
        }

        // Search Foods
        List<Food> matchingFoods = foodRepository.findByNameContaining(query);
        for (Food food : matchingFoods) {
            // For each food, find all associated restaurants and calculate distance for each
            for (Restaurant restaurant : food.getRestaurants()) {  // Use getRestaurants() to get all associated restaurants
                double distance = calculateDistance(userLatitude, userLongitude, restaurant.getLatitude(), restaurant.getLongitude());

                SearchResultDto dto = new SearchResultDto();
                dto.setType("Food");
                dto.setName(food.getName());
                dto.setDistance(distance);  // Set distance in km

                // Get associated restaurant names
                List<String> restaurants = new ArrayList<>();
                restaurants.add(restaurant.getName());
                dto.setAssociatedNames(restaurants);

                results.add(dto);
            }
        }
        results.sort((a, b) -> {
            // Compare by type: Restaurants ("Restaurant") should come before Foods ("Food")
            if (!a.getType().equals(b.getType())) {
                return a.getType().equals("Restaurant") ? -1 : 1;
            }

            // If both are Restaurants, sort by distance
            if (a.getType().equals("Restaurant")) {
                return Double.compare(a.getDistance(), b.getDistance());
            }

            // If both are Foods, first sort by name
            int nameComparison = a.getName().compareTo(b.getName());
            if (nameComparison != 0) {
                return nameComparison;
            }

            // If both are Foods and have the same name, sort by distance
            return Double.compare(a.getDistance(), b.getDistance());
        });

        return results;
    }

    // Calculate the distance between two lat/lon points in kilometers
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c; // Returns the distance in kilometers
    }
}


