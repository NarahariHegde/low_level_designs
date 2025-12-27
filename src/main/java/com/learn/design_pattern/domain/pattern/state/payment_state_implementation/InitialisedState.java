package com.learn.design_pattern.domain.pattern.state.payment_state_implementation;

import com.learn.design_pattern.domain.dto.PaymentResult;
import com.learn.design_pattern.domain.enums.PaymentStatus;
import com.learn.design_pattern.domain.model.PaymentTransaction;
import com.learn.design_pattern.domain.pattern.state.PaymentState;

public class InitialisedState implements PaymentState {

    @Override
    public PaymentStatus getState() {
        return PaymentStatus.INITIATED;
    }

    @Override
    public void process(PaymentTransaction transaction, PaymentResult result) {
        transaction.setStatus(PaymentStatus.SUCCESS);
        transaction.setPaymentState(new ProcessingState());
    }

    @Override
    public void onSuccess(PaymentTransaction transaction) {
        throw new IllegalStateException("not possible at this time as processing is not done.");
    }

    @Override
    public void onFailure(PaymentTransaction transaction) {
        throw new IllegalStateException("not possible at this time as processing is not done.");
    }
}
