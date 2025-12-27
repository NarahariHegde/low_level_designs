package com.learn.design_pattern.domain.pattern.decorator.payment_decorator_implementation;

import com.learn.design_pattern.domain.model.PaymentTransaction;
import com.learn.design_pattern.domain.pattern.decorator.PaymentStrategyDecorator;
import com.learn.design_pattern.domain.pattern.strategy.PaymentStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RetryDecorator extends PaymentStrategyDecorator {

    private final int maxRetries;

    public RetryDecorator(PaymentStrategy paymentStrategy, int maxRetries) {
        super(paymentStrategy);
        this.maxRetries = maxRetries;
    }

    @Override
    public com.learn.design_pattern.domain.dto.PaymentResult pay(PaymentTransaction paymentTransaction) {
        int attempt = 0;
        com.learn.design_pattern.domain.dto.PaymentResult paymentResult;
        do {
            attempt++;
            paymentResult = paymentStrategy.pay(paymentTransaction);

            if (!paymentResult.isReTryable()) {
                return paymentResult;
            }
            log.warn("retrying payment | attempt={} ", attempt);
        } while (attempt <= maxRetries);
        return paymentResult;
    }
}
