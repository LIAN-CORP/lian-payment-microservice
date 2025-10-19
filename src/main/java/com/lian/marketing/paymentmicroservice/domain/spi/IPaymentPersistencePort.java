package com.lian.marketing.paymentmicroservice.domain.spi;

import com.lian.marketing.paymentmicroservice.domain.model.Payment;

import java.util.List;
import java.util.UUID;

public interface IPaymentPersistencePort {
    void savePayment(Payment payment);
    boolean clientExists(UUID clientId);
    List<Payment> findAllByDebtId(UUID debtId);
}
