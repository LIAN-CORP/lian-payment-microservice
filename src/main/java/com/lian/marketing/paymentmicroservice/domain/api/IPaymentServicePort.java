package com.lian.marketing.paymentmicroservice.domain.api;

import com.lian.marketing.paymentmicroservice.domain.model.Payment;

import java.util.List;
import java.util.UUID;

public interface IPaymentServicePort {
    void createPaymentFromTransaction(Payment payment);
    void createPaymentDebt(Payment payment);
    List<Payment> findDebtPaymentsByDebtId(UUID debtId);
}
