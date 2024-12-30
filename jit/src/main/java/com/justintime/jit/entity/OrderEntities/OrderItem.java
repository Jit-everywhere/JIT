package com.justintime.jit.entity.OrderEntities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.justintime.jit.entity.ComboEntities.Combo;
import com.justintime.jit.entity.MenuItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Audited
@Table(name = "order_item")
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "order_id", nullable = false)
        @JsonIgnoreProperties("orderItems")
        private Order order;

        @ManyToOne
        @JoinColumn(name = "menu_item_id", nullable = false)
        @JsonIgnoreProperties("orderItems")
        private MenuItem menuItem;

        @ManyToOne
        @JoinColumn(name = "combo_id", nullable = false)
        @JsonIgnoreProperties("orderItems")
        private Combo combo;

        @Column(name = "quantity", nullable = false, columnDefinition = "int default 1")
        private int quantity;

        @Column(name = "price", nullable = false, columnDefinition = "decimal(10,2) default 0.00")
        private BigDecimal price;

        @CreationTimestamp
        @Column(name = "created_dttm", nullable = false, updatable = false)
        private LocalDateTime createdDttm;

        @UpdateTimestamp
        @Column(name = "updated_dttm", nullable = false)
        private LocalDateTime updatedDttm;

        // Copy Constructor
        public OrderItem(OrderItem other) {
                this.id = null; // New instance should not have the same ID
                this.order = other.order; // Shallow copy, assuming `Order` is managed elsewhere
                this.menuItem = new MenuItem(other.menuItem); // Deep copy of MenuItem
                this.combo = new Combo(other.combo); // Deep copy of Combo
                this.quantity = other.quantity;
                this.price = other.price;
                this.createdDttm = other.createdDttm;
                this.updatedDttm = other.updatedDttm;
        }
}

