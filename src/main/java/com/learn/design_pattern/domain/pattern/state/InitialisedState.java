package com.learn.design_pattern.domain.pattern.state;

import com.learn.design_pattern.domain.model.PaymentTransaction;

public class InitialisedState implements PaymentState {

    @Override
    public void process(PaymentTransaction transaction) {
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
