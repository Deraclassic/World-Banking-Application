package com.dera.World.Banking.service;

import com.dera.World.Banking.payload.request.TransactionRequest;

public interface TransactionService {
    void saveTransactions(TransactionRequest transactionRequest);
}
