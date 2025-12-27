package com.learn.design_pattern.application;

import com.learn.design_pattern.domain.dto.PaymentResult;
import com.learn.design_pattern.domain.model.OutBoxEvent;
import com.learn.design_pattern.domain.model.PaymentTransaction;
import com.learn.design_pattern.domain.pattern.factory.PaymentStrategyFactory;
import com.learn.design_pattern.domain.pattern.state.payment_state_implementation.PaymentResolver;
import com.learn.design_pattern.domain.pattern.strategy.PaymentStrategy;
import com.learn.design_pattern.domain.tools.messagequeues.PaymentEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentStrategyFactory paymentStrategyFactory;
    private final OutBoxEvent event;

    @Transactional
    public PaymentResult makePayment(PaymentTransaction paymentTransaction) {
        PaymentResolver.resolve(paymentTransaction.getStatus());

        PaymentStrategy paymentStrategy = paymentStrategyFactory.getStrategy(paymentTransaction.getPaymentType());
        PaymentResult paymentResult = paymentStrategy.pay(paymentTransaction);

        PaymentResolver.resolve(paymentTransaction.getStatus());

        OutBoxEvent events = OutBoxEvent.builder()
                .transaction(paymentTransaction)
                .paymentEvent(PaymentEvent.builder().paymentTransaction(paymentTransaction).timeStamp(Instant.now())
                        .build()).createdAt(Instant.now()).build();

        event.setEventList(Collections.singletonList(events));
        return paymentResult;
    }
}
