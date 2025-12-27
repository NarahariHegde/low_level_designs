package com.learn.design_pattern.domain.pattern.state.payment_state_implementation;

import com.learn.design_pattern.domain.enums.PaymentStatus;
import com.learn.design_pattern.domain.pattern.state.PaymentState;

public class PaymentResolver {

    public static PaymentState resolve(PaymentStatus paymentStatus)
    {
       return switch (paymentStatus)
        {
            case INITIATED -> new InitialisedState();
            case PROCESSING -> new ProcessingState();
            case SUCCESS -> new SuccessState();
            case FAILED -> new FailedState();
            case REFUNDED, CREATED, CANCEL, STARTED -> null;
        };
    }
}
