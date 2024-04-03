package com.dera.World.Banking.service;

import com.dera.World.Banking.payload.request.CreditAndDebitRequest;
import com.dera.World.Banking.payload.request.EnquiryRequest;
import com.dera.World.Banking.payload.request.TransferRequest;
import com.dera.World.Banking.payload.response.BankResponse;

public interface UserService {
    BankResponse creditAccount(CreditAndDebitRequest request);

    BankResponse debitAccount(CreditAndDebitRequest request);
    BankResponse balanceEnquiry(EnquiryRequest enquiryRequest);
    String nameEnquiry(EnquiryRequest enquiryRequest);
    BankResponse transfer(TransferRequest request);
}
