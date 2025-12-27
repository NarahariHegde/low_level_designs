package com.learn.design_pattern.domain.pattern.decorator;

import com.learn.design_pattern.domain.enums.PaymentType;
import com.learn.design_pattern.domain.pattern.strategy.PaymentStrategy;

public abstract class PaymentStrategyDecorator implements PaymentStrategy {
    protected PaymentStrategy paymentStrategy;

    public PaymentStrategyDecorator(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    @Override
    public PaymentType supportedTransactionType() {
        return paymentStrategy.supportedTransactionType();
    }
}
