package com.justintime.jit.entity.OrderEntities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.justintime.jit.entity.PaymentEntities.Payment;
import com.justintime.jit.entity.Restaurant;
import com.justintime.jit.entity.User;
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
@Table(name = "order_activity")
public class OrderActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnoreProperties("orderActivities")
    private Order order;

    @Column(name = "change_log", nullable = false, length = 50)
    private String changeLog;

    @Column(name = "updated_by", nullable = false, length = 100)
    private String updatedBy;

    @UpdateTimestamp
    @Column(name = "updated_dttm", nullable = false)
    private LocalDateTime updatedDttm;

}
