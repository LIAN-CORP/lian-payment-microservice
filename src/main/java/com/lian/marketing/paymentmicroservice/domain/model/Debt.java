package com.lian.marketing.paymentmicroservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Debt {
    private UUID id;
    private BigDecimal totalAmount;
    private BigDecimal remainingAmount;
    private StatusDebt status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UUID clientId;
}
