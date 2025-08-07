package com.lian.marketing.paymentmicroservice.domain.spi;

import com.lian.marketing.paymentmicroservice.domain.model.Payment;

public interface IPaymentPersistencePort {
    void savePayment(Payment payment);
}
