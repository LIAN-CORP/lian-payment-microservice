package com.lian.marketing.paymentmicroservice.infrastructure.driving.http.controller;

import com.lian.marketing.paymentmicroservice.application.dto.request.CreateDebtRequest;
import com.lian.marketing.paymentmicroservice.application.handler.DebtHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/debt")
@RequiredArgsConstructor
public class DebtController {

    private final DebtHandler debtHandler;

    @PostMapping
    public ResponseEntity<Void> createDebtFromTransaction(@Valid @RequestBody CreateDebtRequest request) {
        debtHandler.createDebt(request);
        return ResponseEntity.ok().build();
    }

}
