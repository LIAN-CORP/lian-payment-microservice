package com.lian.marketing.paymentmicroservice.domain.api;

import com.lian.marketing.paymentmicroservice.domain.model.Payment;

public interface IPaymentServicePort {
    void createPaymentFromTransaction(Payment payment);
}
