package com.learn.design_pattern.domain.model;

import com.learn.design_pattern.domain.enums.PaymentStatus;
import com.learn.design_pattern.domain.enums.PaymentType;
import com.learn.design_pattern.domain.pattern.state.PaymentState;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentTransaction {
    private String transactionId;
    private User user;
    private PaymentType paymentType;
    private double amount;
    private PaymentState paymentState;
    private IdempotencyKey idempotencyKey;
    private PaymentStatus status;

}
