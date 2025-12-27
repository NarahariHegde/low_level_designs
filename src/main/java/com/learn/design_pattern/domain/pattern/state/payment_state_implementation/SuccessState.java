package com.learn.design_pattern.domain.pattern.state.payment_state_implementation;

import com.learn.design_pattern.domain.dto.PaymentResult;
import com.learn.design_pattern.domain.enums.PaymentStatus;
import com.learn.design_pattern.domain.model.PaymentTransaction;
import com.learn.design_pattern.domain.pattern.state.PaymentState;

public class SuccessState implements PaymentState {
    @Override
    public PaymentStatus getState() {
        return PaymentStatus.SUCCESS;
    }

    @Override
    public void process(PaymentTransaction transaction, PaymentResult result) {

    }

    @Override
    public void onSuccess(PaymentTransaction transaction) {
        throw new IllegalStateException("payment is already succeeded.");
    }

    @Override
    public void onFailure(PaymentTransaction transaction) {
    }
}
