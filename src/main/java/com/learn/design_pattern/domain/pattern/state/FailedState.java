package com.learn.design_pattern.domain.pattern.state;

import com.learn.design_pattern.domain.model.PaymentTransaction;

public class FailedState implements PaymentState {
    @Override
    public void process(PaymentTransaction transaction) {
        throw new IllegalStateException("not possible at this time as processing failed.");
    }

    @Override
    public void onSuccess(PaymentTransaction transaction) {
        throw new IllegalStateException("not possible at this time as processing failed.");
    }

    @Override
    public void onFailure(PaymentTransaction transaction) {

    }
}
