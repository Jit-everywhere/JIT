package com.justintime.jit.entity.ComboEntities;


import com.justintime.jit.entity.MenuItem;
import com.justintime.jit.entity.OrderEntities.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Audited
@Data
@Table(name="combo_item")
@NoArgsConstructor
@AllArgsConstructor
public class ComboItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "combo_item_combo",
            joinColumns = @JoinColumn(name = "combo_item_id"),
            inverseJoinColumns = @JoinColumn(name = "combo_id")
    )
    private Set<Combo> comboSet = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="menu_item_id",nullable = false)
    private MenuItem menuItem;

    @Column(name = "created_dttm", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDttm = LocalDateTime.now();

    @Column(name = "updated_dttm", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedDttm = LocalDateTime.now();

}
