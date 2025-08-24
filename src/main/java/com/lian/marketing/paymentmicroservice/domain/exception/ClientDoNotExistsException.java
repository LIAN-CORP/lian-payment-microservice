package com.lian.marketing.paymentmicroservice.domain.exception;

public class ClientDoNotExistsException extends RuntimeException {
    public ClientDoNotExistsException(String message) {
        super(message);
    }
}
