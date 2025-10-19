package com.lian.marketing.paymentmicroservice.infrastructure.driving.http.controller;

import com.lian.marketing.paymentmicroservice.application.dto.request.CreateDebtRequest;
import com.lian.marketing.paymentmicroservice.application.handler.DebtHandler;
import com.lian.marketing.paymentmicroservice.domain.model.ActiveDebt;
import com.lian.marketing.paymentmicroservice.domain.model.ContentPage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/active")
    public ResponseEntity<ContentPage<ActiveDebt>> findActiveDebts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "true") boolean dateAsc
    ) {
        return ResponseEntity.ok().body(
                debtHandler.findActiveDebts(page, size, dateAsc)
        );
    }
}
