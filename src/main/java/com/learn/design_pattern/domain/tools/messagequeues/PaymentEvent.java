package com.learn.design_pattern.domain.tools.messagequeues;

import com.learn.design_pattern.domain.model.PaymentTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
@Builder
public class PaymentEvent {
    private final PaymentTransaction paymentTransaction;
    private final Instant timeStamp;
}
