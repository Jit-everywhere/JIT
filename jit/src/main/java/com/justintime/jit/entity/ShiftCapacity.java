package com.justintime.jit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Audited
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
        @JsonIgnoreProperties("shiftCapacities")
        private Restaurant restaurant;

        @Column(name = "start_time", nullable = false)
        private LocalTime startTime;

        @Column(name = "end_time", nullable = false)
        private LocalTime endTime;

        @Column(name = "total_capacity", nullable = false)
        private Integer totalCapacity;

        @CreationTimestamp
        @Column(name = "created_dttm", nullable = false, updatable = false)
        private LocalDateTime createdDttm;

        @UpdateTimestamp
        @Column(name = "updated_dttm", nullable = false)
        private LocalDateTime updatedDttm;

        @OneToMany(mappedBy = "shiftCapacity", cascade = CascadeType.ALL)
        @JsonIgnoreProperties("shiftCapacity")
        private List<Reservation> reservations;

}

