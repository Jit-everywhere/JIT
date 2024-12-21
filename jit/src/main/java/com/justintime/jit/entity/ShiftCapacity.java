package com.justintime.jit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "shift_capacity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShiftCapacity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "restaurant_id", nullable = false)
        private Restaurant restaurant;

        @Column(name = "start_time", nullable = false)
        private LocalTime startTime;

        @Column(name = "end_time", nullable = false)
        private LocalTime endTime;

        @Column(name = "total_capacity", nullable = false)
        private Integer totalCapacity;

        @Column(name = "created_dttm", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        private LocalDateTime createdDttm;

        @Column(name = "updated_dttm", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        private LocalDateTime updatedDttm;

        @OneToMany(mappedBy = "shiftCapacity", cascade = CascadeType.ALL)
        private List<Reservation> reservations;


}

