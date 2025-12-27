package com.learn.design_pattern.domain.tools.messagequeues.publisher;

import com.learn.design_pattern.domain.tools.messagequeues.PaymentEvent;
import com.learn.design_pattern.domain.tools.messagequeues.PaymentEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KafkaPaymentEventPublisher implements PaymentEventPublisher {

    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;
    private static final String TOPIC = "payment-events";

    @Override
    public void publish(PaymentEvent paymentEvent) {
        kafkaTemplate.send(TOPIC, paymentEvent.getPaymentTransaction().getTransactionId(), paymentEvent);
    }
}
