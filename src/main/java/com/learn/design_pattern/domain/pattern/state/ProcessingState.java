package com.learn.design_pattern.domain.pattern.state;

import com.learn.design_pattern.domain.model.PaymentTransaction;

public class ProcessingState implements PaymentState {
    @Override
    public void process(PaymentTransaction transaction) {

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
