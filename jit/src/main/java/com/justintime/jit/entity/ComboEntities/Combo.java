package com.justintime.jit.entity.ComboEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.justintime.jit.entity.OrderEntities.Order;
import com.justintime.jit.entity.OrderEntities.OrderItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
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

    // Getter for comboItemSet returns an unmodifiable set to avoid external modifications
    public Set<ComboItem> getComboItemSet() {
        return Collections.unmodifiableSet(comboItemSet);
    }

    // Setter for comboItemSet ensures defensive copy to prevent modification of the internal state
    public void setComboItemSet(Set<ComboItem> comboItemSet) {
        this.comboItemSet = comboItemSet != null
                ? new HashSet<>(comboItemSet) // Defensive copy
                : new HashSet<>();
    }

    // Getter for orderItems returns an unmodifiable list to avoid external modifications
    public List<OrderItem> getOrderItems() {
        return Collections.unmodifiableList(orderItems);
    }

    // Setter for orderItems ensures defensive copy to prevent modification of the internal state
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems != null
                ? orderItems.stream().map(item -> new OrderItem(item)).collect(Collectors.toList()) // Defensive copy
                : null;
    }

    // Copy constructor to create a deep copy of the Combo object and its mutable fields
    public Combo(Combo other) {
        this.id = other.id;
        this.price = other.price;
        this.stock = other.stock;
        this.createdDttm = other.createdDttm;
        this.updatedDttm = other.updatedDttm;

        // Deep copy of comboItemSet to avoid sharing mutable objects
        this.comboItemSet = other.comboItemSet != null
                ? other.comboItemSet.stream().map(item -> new ComboItem(item)).collect(Collectors.toSet())
                : new HashSet<>();

        // Deep copy of orderItems to avoid sharing mutable objects
        this.orderItems = other.orderItems != null
                ? other.orderItems.stream().map(orderItem -> new OrderItem(orderItem)).collect(Collectors.toList())
                : null;
    }

    // hashCode() and equals() method should no longer have redundant null checks
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Combo combo = (Combo) o;
        return id != null && id.equals(combo.id);  // compare by id, assuming id is the unique identifier
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;  // hash based on id
    }
}