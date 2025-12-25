package com.learn.design_pattern.domain.pattern.strategy;

import com.learn.design_pattern.domain.dto.PaymentResult;
import com.learn.design_pattern.domain.enums.PaymentType;
import com.learn.design_pattern.domain.model.PaymentTransaction;

public interface PaymentStrategy {
    PaymentType supports();
    PaymentResult pay(PaymentTransaction paymentTransaction);
}
