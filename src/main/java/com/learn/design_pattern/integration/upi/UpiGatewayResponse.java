package com.learn.design_pattern.integration.upi;

public record UpiGatewayResponse(String code, String transactionId, String message) {
}
