package com.learn.design_pattern.domain.pattern.state.payment_state_implementation;

import com.learn.design_pattern.domain.dto.PaymentResult;
import com.learn.design_pattern.domain.enums.PaymentStatus;
import com.learn.design_pattern.domain.model.PaymentTransaction;
import com.learn.design_pattern.domain.pattern.state.PaymentState;

public class FailedState implements PaymentState {
    @Override
    public PaymentStatus getState() {
        return PaymentStatus.FAILED;
    }

    @Override
    public void process(PaymentTransaction transaction, PaymentResult result) {
    }

    @Override
    public void onSuccess(PaymentTransaction transaction) {
    }

    @Override
    public void onFailure(PaymentTransaction transaction) {
        throw new IllegalStateException("not possible at this time as processing failed.");

    }
}
