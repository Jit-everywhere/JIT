package com.justintime.jit.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "food_restaurant")
public class FoodRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
}
