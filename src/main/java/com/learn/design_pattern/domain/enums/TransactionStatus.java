package com.learn.design_pattern.domain.enums;

public enum TransactionStatus {
    SUCCESS("00"), FAILED("01"), RETRY("02"), REFUND("03"), CANCEL("04"), RECONCILE("05");
    private final String statusCode;

    TransactionStatus(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
