package com.justintime.jit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.justintime.jit.entity.Enums.Role;
import com.justintime.jit.entity.OrderEntities.Order;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Audited
@Data
@Table(name = "users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "first_name", nullable = false)
        private String firstName;

        @Column(name = "last_name", nullable = false)
        private String lastName;

        @Column(name = "profile_picture_url")
        private String profilePictureUrl;

        @Column(name = "is_active", nullable = false)
        private Boolean isActive;

        @Column(name = "user_name", nullable = false)
        private String userName;

        @Column(name = "email", nullable = false)
        private String email;

        @Column(name = "phone_number")
        private String phoneNumber;

        @Column(name = "password_hash", nullable = false)
        private String passwordHash;

        @Enumerated(EnumType.STRING)
        @Column(name = "role", nullable = false)
        private Role role;

        @CreationTimestamp
        @Column(name = "created_dttm", nullable = false, updatable = false)
        private LocalDateTime createdDttm;

        @UpdateTimestamp
        @Column(name = "updated_dttm", nullable = false)
        private LocalDateTime updatedDttm;

        @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
        @JsonIgnoreProperties("customer")
        private List<Order> orders;

        @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
        @JsonIgnoreProperties("customer")
        private List<Reservation> reservations;

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
        @JsonIgnoreProperties("user")
        private List<Admin> admins;

}
