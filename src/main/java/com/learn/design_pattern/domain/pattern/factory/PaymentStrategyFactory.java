package com.learn.design_pattern.domain.pattern.factory;

import com.learn.design_pattern.domain.enums.PaymentType;
import com.learn.design_pattern.domain.pattern.strategy.PaymentStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PaymentStrategyFactory {
    private final Map<PaymentType, PaymentStrategy> strategyMap;

    public PaymentStrategyFactory(List<PaymentStrategy> paymentStrategies) {
        this.strategyMap = paymentStrategies.stream().collect(Collectors.toMap(PaymentStrategy::supports, Function.identity()));
    }

    public PaymentStrategy getStrategy(PaymentType paymentType) {
        return strategyMap.get(paymentType);
    }

}
