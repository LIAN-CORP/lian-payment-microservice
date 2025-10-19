package com.lian.marketing.paymentmicroservice.infrastructure.driving.http.controller;

import com.lian.marketing.paymentmicroservice.application.dto.request.CreatePaymentRequest;
import com.lian.marketing.paymentmicroservice.application.handler.PaymentHandler;
import com.lian.marketing.paymentmicroservice.domain.model.Payment;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentHandler paymentHandler;

    @PostMapping("/transaction")
    public ResponseEntity<Void> createPaymentFromTransaction(@Valid @RequestBody CreatePaymentRequest request) {
        paymentHandler.createPaymentFromTransaction(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/debt")
    public ResponseEntity<Void> createPaymentDebt(@Valid @RequestBody CreatePaymentRequest request) {
        paymentHandler.createPaymentDebt(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/debt/{id}")
    public ResponseEntity<List<Payment>> findDebtPaymentsByDebtId(@PathVariable UUID id) {
        return ResponseEntity.ok().body(paymentHandler.findDebtPaymentsByDebtId(id));
    }

}
