package com.learn.design_pattern.domain.model;

import com.learn.design_pattern.domain.tools.messagequeues.PaymentEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Builder
public class OutBoxEvent {
    private UUID id;
    private String status;
    private PaymentTransaction transaction;
    private PaymentEvent paymentEvent;
    private Instant createdAt;
    private List<OutBoxEvent> eventList;
}
