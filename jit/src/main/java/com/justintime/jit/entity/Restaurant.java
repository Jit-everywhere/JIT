package com.justintime.jit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "restaurants")
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "restaurant_name", nullable = false)
        private String restaurantName;

        @ManyToOne
        @JoinColumn(name = "address_id",nullable = false)
        private Address address;

        @Column(name = "contact_number")
        private String contactNumber;

        @Column(name = "email")
        private String email;

        @Column(name = "created_dttm", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        private LocalDateTime createdDttm;

        @Column(name = "updated_dttm", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        private LocalDateTime updatedDttm;

        @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Food> menu;

        @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
        private List<ShiftCapacity> shiftCapacities;

        @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
        private List<Reservation> reservations;
}
