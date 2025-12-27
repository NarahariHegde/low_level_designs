package com.learn.design_pattern.domain.tools;

import com.learn.design_pattern.domain.dto.PaymentResult;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface IdempotencyStore {
    Optional<PaymentResult> get(String key);

    void save(String key, PaymentResult paymentResult);
}
