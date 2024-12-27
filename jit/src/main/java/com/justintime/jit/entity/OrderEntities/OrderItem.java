package com.justintime.jit.entity.OrderEntities;


import com.justintime.jit.entity.ComboEntities.Combo;
import com.justintime.jit.entity.MenuItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Audited
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

        @Column(name = "quantity", nullable = false, columnDefinition = "int default 1")
        private int quantity;

        @Column(name = "price", nullable = false, columnDefinition = "decimal(10,2) default 0.00")
        private BigDecimal price;

        @Column(name = "created_dttm", nullable = false, updatable = false)
        private LocalDateTime createdDttm = LocalDateTime.now();

        @Column(name = "updated_dttm", nullable = false)
        private LocalDateTime updatedDttm = LocalDateTime.now();

}
