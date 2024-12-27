package com.justintime.jit.entity.PaymentEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.justintime.jit.entity.OrderEntities.Order;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Audited
@Table(name = "payment")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnoreProperties("orders")
    private Order order;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "currency", nullable = false)
    private String currency = "USD";

    @Column(name = "payment_status", nullable = false)
    private String paymentStatus;

    @Column(name = "payment_date", nullable = false, updatable = false)
    private LocalDateTime paymentDate = LocalDateTime.now();

    @Column(name = "updated_by")
    private String updatedBy;

    @UpdateTimestamp
    @Column(name = "updated_dttm", nullable = false)
    private LocalDateTime updatedDttm;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

}
