package com.ass1.inv.Controller;

import com.ass1.inv.exception.BadRequestException;
import com.ass1.inv.exception.ResourceNotFoundException;
import com.ass1.inv.model.Transaction;
import com.ass1.inv.service.TransactionService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final Logger log = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable(name = "id") long id) {
        Transaction transaction = transactionService.getTransactionById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id));
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody Transaction transaction) {
        if (transaction.getTransactionId() != null) {
            throw new BadRequestException("Transaction", "id");
        }
        if (transaction.getType() == null) {
            throw new BadRequestException("Transaction", "type");
        }
        Transaction createdTransaction = transactionService.createTransaction(transaction);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@Valid @RequestBody Transaction transaction,
                                                         @PathVariable(name = "id") long id) {
        transactionService.getTransactionById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id));

        Transaction updatedTransaction = transactionService.updateTransaction(id, transaction);
        return ResponseEntity.ok(updatedTransaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable(name = "id") long id) {
        transactionService.getTransactionById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id));

        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
