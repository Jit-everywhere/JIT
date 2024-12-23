package com.justintime.jit.repository.PaymentRepo;

import com.justintime.jit.entity.PaymentEntities.Transaction;
import com.justintime.jit.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends BaseRepository<Transaction, Long> {
}

