package com.ass1.inv.service;

import com.ass1.inv.model.Order;
import com.ass1.inv.model.Transaction;
import com.ass1.inv.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }



    public Transaction updateTransaction(Long id, Transaction transaction) {
        if (transactionRepository.existsById(id)) {
            transaction.setTransactionId(id);
            return transactionRepository.save(transaction);
        }
        return null;
    }

//    public Transaction updateTransaction(Long id, Transaction transaction) {
//        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
//        if (optionalTransaction.isPresent()) {
//            Transaction existingTransaction = optionalTransaction.get();
//            existingTransaction.setType(transaction.getType());
//            existingTransaction.setQuantity(transaction.getQuantity());
//            existingTransaction.setTimestamp(transaction.getTimestamp());
//            return transactionRepository.save(existingTransaction);
//        } else {
//            return null;
//        }
//    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
