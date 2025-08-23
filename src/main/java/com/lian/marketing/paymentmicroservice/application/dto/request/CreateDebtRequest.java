package com.lian.marketing.paymentmicroservice.application.dto.request;

import com.lian.marketing.paymentmicroservice.application.constant.RequestConstants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateDebtRequest(
        @Positive(message = RequestConstants.DEBT_TOTAL_AMOUNT_MUST_BE_VALID_NUMBER)
        BigDecimal totalAmount,

        @NotNull(message = RequestConstants.DEBT_CLIENT_ID_MUST_BE_NOT_EMPTY)
        UUID clientId
) {
}
