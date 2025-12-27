package com.learn.design_pattern.domain.tools.messagequeues.subscriber;

import com.learn.design_pattern.domain.enums.PaymentStatus;
import com.learn.design_pattern.domain.tools.messagequeues.PaymentEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentNotificationConsumer {

    @KafkaListener(topics = "payment-events", groupId = "notification-service")
    public void handle(PaymentEvent paymentEvent) {
        if (paymentEvent.getPaymentTransaction().getStatus() == PaymentStatus.SUCCESS) {
            System.out.println("successfully sent ");
        }
        if (paymentEvent.getPaymentTransaction().getStatus() == PaymentStatus.FAILED) {
            System.out.println("failed to send the msg");
        }
    }
}
