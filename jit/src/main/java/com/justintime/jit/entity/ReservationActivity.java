package com.justintime.jit.entity;
import com.justintime.jit.entity.OrderEntities.Order;
import com.justintime.jit.entity.PaymentEntities.Payment;
import com.justintime.jit.entity.Restaurant;
import com.justintime.jit.entity.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Audited
@Data
@Table(name = "reservation_activity")
public class ReservationActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    @Column(name = "change_log", nullable = false, length = 50)
    private String changeLog;

    @Column(name = "updated_by", nullable = false, length = 100)
    private String updatedBy;

    @Column(name = "updated_dttm", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedDttm = LocalDateTime.now();
}
