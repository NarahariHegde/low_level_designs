package com.learn.design_pattern.domain.pattern.state.payment_state_implementation;

import com.learn.design_pattern.domain.dto.PaymentResult;
import com.learn.design_pattern.domain.enums.PaymentStatus;
import com.learn.design_pattern.domain.enums.TransactionStatus;
import com.learn.design_pattern.domain.model.PaymentTransaction;
import com.learn.design_pattern.domain.pattern.state.PaymentState;

public class ProcessingState implements PaymentState {
    @Override
    public PaymentStatus getState() {
        return PaymentStatus.PROCESSING;
    }

    @Override
    public void process(PaymentTransaction transaction, PaymentResult result) {
        if (result.getTransactionStatus() == TransactionStatus.SUCCESS) {
            transaction.setStatus(PaymentStatus.SUCCESS);
        } else {
            transaction.setStatus(PaymentStatus.FAILED);
        }
    }

    @Override
    public void onSuccess(PaymentTransaction transaction) {
        transaction.setPaymentState(new SuccessState());
    }

    @Override
    public void onFailure(PaymentTransaction transaction) {
        transaction.setPaymentState(new FailedState());
    }
}
