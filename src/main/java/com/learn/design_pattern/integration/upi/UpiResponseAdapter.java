package com.learn.design_pattern.integration.upi;

import com.learn.design_pattern.domain.dto.PaymentResult;
import com.learn.design_pattern.domain.enums.TransactionStatus;
import org.springframework.stereotype.Component;

@Component
public class UpiResponseAdapter {
    public PaymentResult getPaymentResult(UpiGatewayResponse upiGatewayResponse) {
        if (TransactionStatus.SUCCESS.getStatusCode().equals(upiGatewayResponse.code())) {
            return PaymentResult.onSuccess(upiGatewayResponse.transactionId());
        }
        return PaymentResult.onFailure(upiGatewayResponse.message());
    }
}
