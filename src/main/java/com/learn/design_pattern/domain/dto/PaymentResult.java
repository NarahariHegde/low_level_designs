package com.learn.design_pattern.domain.dto;

import com.learn.design_pattern.domain.enums.FailureType;
import com.learn.design_pattern.domain.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Arrays;

@AllArgsConstructor
@Data
@Builder
public class PaymentResult {
    private final boolean transaction_result;
    private final String referenceId;
    private final String failureReason;
    private final FailureType failureType;
    private final TransactionStatus transactionStatus;

    public static PaymentResult onSuccess(String referenceId) {
        return PaymentResult.builder().referenceId(referenceId).transaction_result(true).build();
    }

    public static PaymentResult onFailure(String failureReason) {
        return PaymentResult.builder().transaction_result(false).failureReason(failureReason).build();
    }

    public boolean isSuccess() {
        return transaction_result;
    }

    public boolean isReTryable() {
        return transactionStatus == TransactionStatus.FAILED && (Arrays.asList(FailureType.NETWORK, FailureType.RATE_LIMIT, FailureType.TIMEOUT).contains(transactionStatus));
    }
}
