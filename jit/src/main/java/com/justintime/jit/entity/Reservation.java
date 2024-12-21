package com.justintime.jit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="Reservation")
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "customer_id", nullable = false)
        private User customer;

        @ManyToOne
        @JoinColumn(name = "restaurant_id", nullable = false)
        private Restaurant restaurant;

        @ManyToOne
        @JoinColumn(name = "shift_capacity_id", nullable = false)
        private ShiftCapacity shiftCapacity;

        @Column(name = "reservation_start", nullable = false)
        private LocalDateTime reservationStart;

        @Column(name = "reservation_end", nullable = false)
        private LocalDateTime reservationEnd;

        @Column(name = "head_count", nullable = false)
        private Integer headCount;

        @Column(name = "status", nullable = false, length = 50)
        private String status = "PENDING";

        @Column(name = "created_dttm", nullable = false, updatable = false)
        private LocalDateTime createdDttm = LocalDateTime.now();

        @Column(name = "updated_dttm", nullable = false)
        private LocalDateTime updatedDttm = LocalDateTime.now();

}
