package com.justintime.jit.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
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

        @Column(name = "role", nullable = false)
        private String role;

        @Column(name = "created_dttm", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        private LocalDateTime createdDttm;

        @Column(name = "updated_dttm", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        private LocalDateTime updatedDttm;

        @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
        private List<Reservation> reservations;

}
