package com.lian.marketing.paymentmicroservice.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public record ActiveDebt(
    UUID id,
    BigDecimal remainingAmount,
    String client,
    UUID clientId
) {
}
