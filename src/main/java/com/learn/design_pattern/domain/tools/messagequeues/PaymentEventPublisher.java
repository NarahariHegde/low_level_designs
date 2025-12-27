package com.learn.design_pattern.domain.tools.messagequeues;

public interface PaymentEventPublisher {
    void publish(PaymentEvent paymentEvent);
}
