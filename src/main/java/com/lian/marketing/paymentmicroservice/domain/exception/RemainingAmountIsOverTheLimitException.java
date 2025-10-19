package com.lian.marketing.paymentmicroservice.domain.exception;

public class RemainingAmountIsOverTheLimitException extends RuntimeException {
    public RemainingAmountIsOverTheLimitException(String message) {
        super(message);
    }
}
