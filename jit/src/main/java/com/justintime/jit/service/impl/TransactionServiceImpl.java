package com.justintime.jit.service.impl;


import com.justintime.jit.entity.PaymentEntities.Transaction;
import com.justintime.jit.repository.PaymentRepo.TransactionRepository;
import com.justintime.jit.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl extends BaseServiceImpl<Transaction,Long> implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }


    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }


    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
