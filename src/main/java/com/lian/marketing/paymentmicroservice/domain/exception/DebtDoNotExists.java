package com.lian.marketing.paymentmicroservice.domain.exception;

public class DebtDoNotExists extends RuntimeException {
    public DebtDoNotExists(String message) {
        super(message);
    }
}
