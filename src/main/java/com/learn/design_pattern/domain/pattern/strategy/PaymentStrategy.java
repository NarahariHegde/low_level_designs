package com.learn.design_pattern.domain.pattern.strategy;

import com.learn.design_pattern.domain.dto.PaymentResult;
import com.learn.design_pattern.domain.enums.PaymentType;
import com.learn.design_pattern.domain.model.PaymentTransaction;
import org.springframework.stereotype.Component;

@Component
public interface PaymentStrategy {
    PaymentType supportedTransactionType();
   PaymentResult pay(PaymentTransaction paymentTransaction);
}
