package com.learn.design_pattern.domain.pattern.factory;

import com.learn.design_pattern.domain.enums.PaymentType;
import com.learn.design_pattern.domain.pattern.decorator.payment_decorator_implementation.IndempotentPaymentStrategyDecorator;
import com.learn.design_pattern.domain.pattern.decorator.payment_decorator_implementation.RetryDecorator;
import com.learn.design_pattern.domain.pattern.strategy.PaymentStrategy;
import com.learn.design_pattern.domain.tools.IdempotencyStore;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PaymentStrategyFactory {
    private final Map<PaymentType, PaymentStrategy> strategyMap;

    public PaymentStrategyFactory(List<PaymentStrategy> paymentStrategies, IdempotencyStore store) {
        this.strategyMap = paymentStrategies.stream().collect(Collectors.toUnmodifiableMap(PaymentStrategy::supportedTransactionType, paymentStrategy -> decorate(paymentStrategy, store)));
    }

    public PaymentStrategy getStrategy(PaymentType paymentType) {
        return Optional.ofNullable(strategyMap.get(paymentType)).orElseThrow(() -> new UnsupportedOperationException("No Strategy found for the Operation " + paymentType));
    }

    public PaymentStrategy decorate(PaymentStrategy paymentStrategy, IdempotencyStore store) {
        PaymentStrategy idempotent = new IndempotentPaymentStrategyDecorator(paymentStrategy, store);
        return new RetryDecorator(idempotent, 3);
    }


}
