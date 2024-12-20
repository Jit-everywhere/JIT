package com.justintime.jit.entity;

import com.justintime.jit.entity.ComboEntities.ComboItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "menu_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "restaurant_id", nullable = false)
    private Long restaurantId;

    @Column(name = "food_id", nullable = false)
    private Long foodId;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stock;

    @Column(name = "created_dttm", nullable = false)
    private LocalDateTime createdDttm;

    @Column(name = "updated_dttm", nullable = false)
    private LocalDateTime updatedDttm;

    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL)
    private List<ComboItem> comboItems;
}
