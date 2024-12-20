package com.justintime.jit.repository.PaymentRepo;

import com.justintime.jit.entity.PaymentEntities.Payment;
import com.justintime.jit.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends BaseRepository<Payment ,Long> {
}
