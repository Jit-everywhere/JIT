package com.justintime.jit.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="foodName",nullable = false, length = 100)
    private String foodName;

    @Column(name="description",nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private Double price;

    @Column(name = "created_Dttm", updatable = false)
    private LocalDateTime createdDttm = LocalDateTime.now();

    @Column(name = "updated_Dttm")
    private LocalDateTime updatedDttm = LocalDateTime.now();

    @PreUpdate
    private void setUpdatedAt() {
        this.updatedDttm = LocalDateTime.now();
    }

}
