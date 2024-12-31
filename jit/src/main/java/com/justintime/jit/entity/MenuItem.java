package com.justintime.jit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.justintime.jit.entity.ComboEntities.ComboItem;
import com.justintime.jit.entity.OrderEntities.OrderItem;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Audited
@Table(name = "menu_item")
@Getter
@Setter
@NoArgsConstructor
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnoreProperties("menu")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "food_id", nullable = false)
    @JsonIgnoreProperties("menuItems")
    private Food food;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @CreationTimestamp
    @Column(name = "created_dttm", nullable = false, updatable = false)
    private LocalDateTime createdDttm;

    @UpdateTimestamp
    @Column(name = "updated_dttm", nullable = false)
    private LocalDateTime updatedDttm;

    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("menuItem")
    private List<ComboItem> comboItems = new ArrayList<>();

    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("menuItem")
    private List<OrderItem> orderItems = new ArrayList<>();

    // Copy Constructor
    public MenuItem(MenuItem other) {
        this.id = null; // New instance should not copy the ID (leave it null for persistence)
        this.restaurant = other.restaurant; // Shallow copy, assuming `restaurant` is immutable or managed elsewhere
        this.food = other.food; // Shallow copy, assuming `food` is immutable or managed elsewhere
        this.price = other.price;
        this.stock = other.stock;
        this.createdDttm = other.createdDttm;
        this.updatedDttm = other.updatedDttm;

        // Deep copy the comboItems
        this.comboItems = other.comboItems.stream()
                .map(ComboItem::new) // Assuming ComboItem also has a copy constructor
                .toList();

        // Deep copy the orderItems
        this.orderItems = other.orderItems.stream()
                .map(OrderItem::new) // Assuming OrderItem also has a copy constructor
                .toList();
    }

    public List<ComboItem> getComboItems() {
        return Collections.unmodifiableList(comboItems);
    }

    public void setComboItems(List<ComboItem> comboItems) {
        this.comboItems = comboItems != null ? new ArrayList<>(comboItems) : new ArrayList<>();
    }

    public List<OrderItem> getOrderItems() {
        return Collections.unmodifiableList(orderItems);
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems != null ? new ArrayList<>(orderItems) : new ArrayList<>();
    }
}
