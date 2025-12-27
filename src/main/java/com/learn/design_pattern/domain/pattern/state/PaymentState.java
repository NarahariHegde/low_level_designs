package com.learn.design_pattern.domain.pattern.state;

import com.learn.design_pattern.domain.dto.PaymentResult;
import com.learn.design_pattern.domain.enums.PaymentStatus;
import com.learn.design_pattern.domain.model.PaymentTransaction;

public interface PaymentState {
    PaymentStatus getState();

    void process(PaymentTransaction transaction, PaymentResult paymentResult);

    void onSuccess(PaymentTransaction transaction);

    void onFailure(PaymentTransaction transaction);

}
