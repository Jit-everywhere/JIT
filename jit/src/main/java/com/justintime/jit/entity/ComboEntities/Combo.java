package com.justintime.jit.entity.ComboEntities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "combo")
@NoArgsConstructor
@AllArgsConstructor
public class Combo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "combo_item_id", nullable = false)
    private Long comboItemId;

    @Column(name = "price", nullable = false, columnDefinition = "DECIMAL(10,2) DEFAULT 0")
    private Double price = 0.0;

    @Column(name = "stock", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer stock = 0;

    @Column(name = "created_dttm", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDttm = LocalDateTime.now();

    @Column(name = "updated_dttm", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedDttm = LocalDateTime.now();

    @OneToMany(mappedBy = "combo", cascade = CascadeType.ALL)
    private List<ComboItem> comboItems;

}
