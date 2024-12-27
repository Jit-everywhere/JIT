package com.justintime.jit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.justintime.jit.entity.ComboEntities.ComboItem;
import com.justintime.jit.entity.OrderEntities.OrderItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Audited
@Table(name = "menu_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnoreProperties("menu")
    private Restaurant restaurant;

    @ManyToOne
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
    private List<ComboItem> comboItems;

    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("menuItem")
    private List<OrderItem> orderItems;

}
