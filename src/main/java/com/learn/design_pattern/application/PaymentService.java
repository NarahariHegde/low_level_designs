package com.learn.design_pattern.application;

import com.learn.design_pattern.domain.dto.PaymentResult;
import com.learn.design_pattern.domain.model.PaymentTransaction;
import com.learn.design_pattern.domain.pattern.strategy.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentStrategy paymentStrategy;

    public void makePayment(PaymentTransaction paymentTransaction) {
        paymentTransaction.processTransaction();

        PaymentResult paymentResult = paymentStrategy.pay(paymentTransaction);

        if (paymentResult.isSuccess()) {
            paymentTransaction.onSuccess();
        } else {
            paymentTransaction.onFailure();
        }

    }
}
