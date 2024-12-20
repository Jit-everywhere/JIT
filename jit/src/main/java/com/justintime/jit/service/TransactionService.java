package com.justintime.jit.service;

import com.justintime.jit.entity.PaymentEntities.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TransactionService extends BaseService<Transaction,Long> {
    Transaction saveTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    Optional<Transaction> getTransactionById(Long id);
    void deleteTransaction(Long id);
}
