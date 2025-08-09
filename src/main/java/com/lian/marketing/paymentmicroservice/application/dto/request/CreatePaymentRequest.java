package com.lian.marketing.paymentmicroservice.application.dto.request;

import com.lian.marketing.paymentmicroservice.application.constant.RequestConstants;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record CreatePaymentRequest(
        @Positive(message = RequestConstants.PAYMENT_AMOUNT_MUST_BE_VALID_NUMBER)
        Integer amount,

        @NotEmpty(message = RequestConstants.PAYMENT_METHOD_MUST_BE_NOT_EMPTY)
        String paymentMethod,

        @NotNull(message = RequestConstants.PAYMENT_CLIENT_ID_MUST_BE_NOT_EMPTY)
        UUID clientId,

        @NotNull(message = RequestConstants.PAYMENT_TRANSACTION_ID_MUST_BE_NOT_EMPTY)
        UUID transactionId,

        UUID debtId
) {
}
