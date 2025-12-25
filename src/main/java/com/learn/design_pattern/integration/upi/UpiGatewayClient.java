package com.learn.design_pattern.integration.upi;

import com.learn.design_pattern.domain.enums.TransactionStatus;
import com.learn.design_pattern.domain.model.PaymentTransaction;

public class UpiGatewayClient {
    //basically it has to perform payment to external api/server

    public UpiGatewayResponse doPayment(PaymentTransaction paymentTransaction) {
        if (paymentTransaction.getAmount() < 10000) {
            return new UpiGatewayResponse(TransactionStatus.SUCCESS.getStatusCode(), paymentTransaction.getTransactionId(), "SUCCESS");
        }
        return new UpiGatewayResponse(TransactionStatus.FAILED.getStatusCode(),paymentTransaction.getTransactionId(),"INSUFFICIENT_FUND");
    }
}
