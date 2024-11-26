package com.justintime.jit.service.impl;

import com.justintime.jit.entity.Restaurant;
import com.justintime.jit.repository.RestaurantRepository;
import com.justintime.jit.service.RestaurantService;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    private static final int SUGGESTION_THRESHOLD = 3;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + id));
    }

    @Override
    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
        Restaurant existingRestaurant = getRestaurantById(id);

        // Update fields
        existingRestaurant.setName(restaurant.getName());
        existingRestaurant.setAddress(restaurant.getAddress());
        existingRestaurant.setPhoneNumber(restaurant.getPhoneNumber());

        return restaurantRepository.save(existingRestaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        Restaurant existingRestaurant = getRestaurantById(id);
        restaurantRepository.delete(existingRestaurant);
    }

    public List<String> findSimilarNames(String name) {
        List<String> allNames = restaurantRepository.findAll().stream()
                .map(Restaurant::getName)
                .collect(Collectors.toList());

        return allNames.stream()
                .filter(existingName -> existingName.toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public String suggestCorrectName(String name) {
        List<String> allNames = restaurantRepository.findAll().stream()
                .map(Restaurant::getName)
                .collect(Collectors.toList());

        LevenshteinDistance distance = new LevenshteinDistance();

        return allNames.stream()
                .min(Comparator.comparingInt(existingName -> distance.apply(name.toLowerCase(), existingName.toLowerCase())))
                .filter(existingName -> distance.apply(name.toLowerCase(), existingName.toLowerCase()) <= SUGGESTION_THRESHOLD)
                .orElse(null);
    }
}
