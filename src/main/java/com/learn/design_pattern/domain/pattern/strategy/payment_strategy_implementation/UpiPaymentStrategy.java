package com.learn.design_pattern.domain.pattern.strategy.payment_strategy_implementation;

import com.learn.design_pattern.domain.enums.PaymentType;
import com.learn.design_pattern.domain.model.PaymentTransaction;
import com.learn.design_pattern.domain.pattern.strategy.PaymentStrategy;
import com.learn.design_pattern.integration.upi.UpiGatewayClient;
import com.learn.design_pattern.integration.upi.UpiGatewayResponse;
import com.learn.design_pattern.integration.upi.UpiResponseAdapter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("UPI")
@Primary
public class UpiPaymentStrategy implements PaymentStrategy {
    private final UpiResponseAdapter upiResponseAdapter;
    private final UpiGatewayClient upiGatewayClient;

    public UpiPaymentStrategy(UpiResponseAdapter upiResponseAdapter, UpiGatewayClient upiGatewayClient) {
        this.upiResponseAdapter = upiResponseAdapter;
        this.upiGatewayClient = upiGatewayClient;
    }

    @Override
    public PaymentType supportedTransactionType() {
        return PaymentType.UPI;
    }

    @Override
    public com.learn.design_pattern.domain.dto.PaymentResult pay(PaymentTransaction paymentTransaction) {
        UpiGatewayResponse upiGatewayResponse = upiGatewayClient.doPayment(paymentTransaction);
        return upiResponseAdapter.getPaymentResult(upiGatewayResponse);
    }
}
