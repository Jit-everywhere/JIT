package com.justintime.jit.repository;

import com.justintime.jit.entity.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends BaseRepository<Restaurant, Long> {

    // Find a restaurant by name
    Restaurant findByName(String name);

    // Get all restaurants
    List<Restaurant> findAll();

    List<Restaurant> findByNameContaining(String name);
    @Query("SELECT r FROM Restaurant r JOIN r.menu f WHERE f.id = :foodId")
    List<Restaurant> findByFoodId(@Param("foodId") Long foodId);

}
