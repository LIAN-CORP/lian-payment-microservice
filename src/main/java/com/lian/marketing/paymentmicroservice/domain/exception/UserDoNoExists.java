package com.lian.marketing.paymentmicroservice.domain.exception;

public class UserDoNoExists extends RuntimeException {
    public UserDoNoExists(String message) {
        super(message);
    }
}
