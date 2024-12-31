package com.justintime.jit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.justintime.jit.entity.OrderEntities.Order;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Audited
@Getter
@Setter
@Table(name = "restaurants")
@NoArgsConstructor
public class Restaurant {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "restaurant_name", nullable = false)
        private String restaurantName;

        @Column(name = "contact_number")
        private String contactNumber;

        @Column(name = "email")
        private String email;

        @CreationTimestamp
        @Column(name = "created_dttm", nullable = false, updatable = false)
        private LocalDateTime createdDttm;

        @UpdateTimestamp
        @Column(name = "updated_dttm", nullable = false)
        private LocalDateTime updatedDttm;

        @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
        @JsonIgnoreProperties("restaurant")
        private List<Address> addresses;

        @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
        @JsonIgnoreProperties("restaurant")
        private List<MenuItem> menu;

        @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
        @JsonIgnoreProperties("restaurant")
        private List<Order> orders;

        @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
        @JsonIgnoreProperties("restaurant")
        private List<ShiftCapacity> shiftCapacities;

        @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
        @JsonIgnoreProperties("restaurant")
        private List<Reservation> reservations;

        @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
        @JsonIgnoreProperties("restaurant")
        private List<Admin> admins;

        public Restaurant(Restaurant other) {
                this.id = other.id;
                this.restaurantName = other.restaurantName;
                this.contactNumber = other.contactNumber;
                this.email = other.email;
                this.createdDttm = other.createdDttm;
                this.updatedDttm = other.updatedDttm;
                this.addresses = other.addresses != null ? other.addresses.stream().map(Address::new).collect(Collectors.toList()) : null;
                this.menu = other.menu != null ? other.menu.stream().map(MenuItem::new).collect(Collectors.toList()) : null;
                this.orders = other.orders != null ? other.orders.stream().map(Order::new).collect(Collectors.toList()) : null;
                this.shiftCapacities = other.shiftCapacities != null ? other.shiftCapacities.stream().map(ShiftCapacity::new).collect(Collectors.toList()) : null;
                this.reservations = other.reservations != null ? other.reservations.stream().map(Reservation::new).collect(Collectors.toList()) : null;
                this.admins = other.admins != null ? other.admins.stream().map(Admin::new).collect(Collectors.toList()) : null;
        }
}
