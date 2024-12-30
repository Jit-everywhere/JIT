package com.justintime.jit.entity.ComboEntities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.justintime.jit.entity.OrderEntities.Order;
import com.justintime.jit.entity.OrderEntities.OrderItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Audited
@Data
@Table(name = "combo")
@NoArgsConstructor
@AllArgsConstructor
public class Combo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "comboSet")
    private Set<ComboItem> comboItemSet = new HashSet<>();

    @Column(name = "price", nullable = false, columnDefinition = "DECIMAL(10,2) DEFAULT 0")
    private Double price = 0.0;

    @Column(name = "stock", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer stock = 0;

    @CreationTimestamp
    @Column(name = "created_dttm", nullable = false, updatable = false)
    private LocalDateTime createdDttm;

    @UpdateTimestamp
    @Column(name = "updated_dttm", nullable = false)
    private LocalDateTime updatedDttm;

    @OneToMany(mappedBy = "combo", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("combo")
    private List<OrderItem> orderItems;

    // Make comboItemSet immutable to protect internal state
    public Set<ComboItem> getComboItemSet() {
        return Collections.unmodifiableSet(comboItemSet);
    }

    // To avoid direct modification, the setter is omitted or can be customized for defensive copying
    public void setComboItemSet(Set<ComboItem> comboItemSet) {
        this.comboItemSet = comboItemSet != null ? new HashSet<>(comboItemSet) : new HashSet<>();
    }

    public Combo(Combo other) {
        this.id = other.id;
        this.price = other.price;
        this.stock = other.stock;
        this.createdDttm = other.createdDttm;
        this.updatedDttm = other.updatedDttm;

        // Deep copy of comboItemSet to ensure mutable objects are not shared
        this.comboItemSet = other.comboItemSet != null
                ? other.comboItemSet.stream().map(item -> new ComboItem(item)).collect(Collectors.toSet())
                : new HashSet<>();

        // If you have any collections like orderItems, make sure to deep copy them as well
        this.orderItems = other.orderItems != null
                ? other.orderItems.stream().map(orderItem -> new OrderItem(orderItem)).collect(Collectors.toList())
                : null;
    }
}

