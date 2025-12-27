package com.learn.design_pattern.api;

import com.learn.design_pattern.application.PaymentService;
import com.learn.design_pattern.domain.dto.PaymentResult;
import com.learn.design_pattern.domain.model.PaymentTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class paymentController {
    private final PaymentService paymentService;

    @GetMapping("/doPayment")
    public ResponseEntity<PaymentResult> makePayment(@RequestBody PaymentTransaction paymentTransaction) {
        paymentService.makePayment(paymentTransaction);
        return ResponseEntity.ofNullable(paymentService.makePayment(paymentTransaction));
    }
}
