package com.justintime.jit.entity.OrderEntities;

import com.justintime.jit.entity.PaymentEntities.Payment;
import com.justintime.jit.entity.Restaurant;
import com.justintime.jit.entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User customer;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(nullable = false)
    private String status; // Example: "PENDING", "PREPARING", "READY", "COMPLETED"

    @Column(name = "order_time", nullable = false)
    private LocalDateTime orderTime;

    @Column(name = "batch_time", nullable = false)
    private LocalDateTime batchTime;

    @Column(name = "created_Dttm", updatable = false)
    private LocalDateTime createdDttm = LocalDateTime.now();

    @Column(name = "updated_Dttm")
    private LocalDateTime updatedDttm = LocalDateTime.now();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Payment payment;

    @PreUpdate
    private void setUpdatedAt() {
        this.updatedDttm = LocalDateTime.now();
    }

    // Getters and Setters
}
