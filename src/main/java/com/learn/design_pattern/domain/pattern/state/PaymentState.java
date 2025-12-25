package com.learn.design_pattern.domain.pattern.state;

import com.learn.design_pattern.domain.model.PaymentTransaction;

public interface PaymentState {
    void process(PaymentTransaction transaction);

    void onSuccess(PaymentTransaction transaction);

    void onFailure(PaymentTransaction transaction);

}
