package com.learn.design_pattern.domain.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaymentResult {
    private final boolean transaction_result;
    private final String referenceId;
    private final String failureReason;

    public static PaymentResult onSuccess(String referenceId) {
        return new PaymentResult(true, referenceId, null);
    }

    public static PaymentResult onFailure(String failureReason) {
        return new PaymentResult(false, null, failureReason);
    }

    public boolean isSuccess() {
        return transaction_result;
    }
}
