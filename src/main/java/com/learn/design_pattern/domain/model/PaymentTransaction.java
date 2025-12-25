package com.learn.design_pattern.domain.model;

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

    public void processTransaction() {
        paymentState.process(this);
    }

    public void onSuccess() {
        paymentState.onSuccess(this);
    }

    public void onFailure() {
        paymentState.onFailure(this);
    }

    public void setState(PaymentState paymentState) {
        this.paymentState = paymentState;
    }

}
