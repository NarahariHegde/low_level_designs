package com.learn.design_pattern.domain.pattern.decorator.payment_decorator_implementation;

import com.learn.design_pattern.domain.model.PaymentTransaction;
import com.learn.design_pattern.domain.pattern.decorator.PaymentStrategyDecorator;
import com.learn.design_pattern.domain.pattern.strategy.PaymentStrategy;
import com.learn.design_pattern.domain.tools.IdempotencyStore;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IndempotentPaymentStrategyDecorator extends PaymentStrategyDecorator {
    private final IdempotencyStore store;

    public IndempotentPaymentStrategyDecorator(PaymentStrategy paymentStrategy, IdempotencyStore idempotencyStore) {
        super(paymentStrategy);
        this.store = idempotencyStore;
    }

    @Override
    public com.learn.design_pattern.domain.dto.PaymentResult pay(PaymentTransaction paymentTransaction) {
        String key = paymentTransaction.getIdempotencyKey().key();
        Optional<com.learn.design_pattern.domain.dto.PaymentResult> cached = store.get(key);
        if (cached.isPresent()) {
            return cached.get();
        }
        com.learn.design_pattern.domain.dto.PaymentResult paymentResult = paymentStrategy.pay(paymentTransaction);
        store.save(key, paymentResult);

        return paymentResult;
    }
}
