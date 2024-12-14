package com.justintime.jit.repository;

import com.justintime.jit.entity.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends BaseRepository<Transaction, Long> {
    // Custom queries can be added here if needed
}

