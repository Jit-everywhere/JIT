package com.justintime.jit.entity.OrderEntities;


import com.justintime.jit.entity.ComboEntities.Combo;
import com.justintime.jit.entity.MenuItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="order_item")
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "order_id", nullable = false)
        private Order order;

        @ManyToOne
        @JoinColumn(name = "menu_item_id", nullable = false)
        private MenuItem menuItem;

        @ManyToOne
        @JoinColumn(name = "combo_id", nullable = false)
        private Combo combo;

        @Column(nullable = false, columnDefinition = "int default 1")
        private int quantity;

        @Column(nullable = false, columnDefinition = "decimal(10,2) default 0.00")
        private BigDecimal price;

        @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        private LocalDateTime createdDttm;

        @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        private LocalDateTime updatedDttm;

}
