package com.learn.design_pattern.domain.enums;

public enum PaymentType {
    UPI("UPI"), CARD("CARD"), NET_BANKING("NET_BANKING");

    private final String paymentType;

    PaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentType() {
        return paymentType;
    }
}
