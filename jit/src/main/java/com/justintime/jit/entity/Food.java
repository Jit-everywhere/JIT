package com.justintime.jit.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Audited
@Data
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="food_name",nullable = false, length = 100)
    private String foodName;

    @Column(name="description",nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "created_dttm", updatable = false)
    private LocalDateTime createdDttm = LocalDateTime.now();

    @Column(name = "updated_dttm")
    private LocalDateTime updatedDttm = LocalDateTime.now();

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<MenuItem> menuItems;

    @PreUpdate
    private void setUpdatedAt() {
        this.updatedDttm = LocalDateTime.now();
    }

}
