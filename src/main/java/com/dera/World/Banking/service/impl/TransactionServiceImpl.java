package com.dera.World.Banking.service.impl;

import com.dera.World.Banking.domain.entities.Transaction;
import com.dera.World.Banking.payload.request.TransactionRequest;
import com.dera.World.Banking.repository.TransactionRepository;
import com.dera.World.Banking.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    @Override
    public void saveTransactions(TransactionRequest transactionRequest) {
        Transaction transaction = Transaction.builder()
                .transactionType(transactionRequest.getTransactionType())
                .accountNumber(transactionRequest.getAccountNumber())
                .amount(transactionRequest.getAmount())
                .status("SUCCESS")
                .build();

        transactionRepository.save(transaction);

        System.out.println("Transaction Saved Successfully!");

    }
}
