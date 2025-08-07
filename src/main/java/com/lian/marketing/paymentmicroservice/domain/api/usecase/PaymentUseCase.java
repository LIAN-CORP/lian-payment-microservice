package com.lian.marketing.paymentmicroservice.domain.api.usecase;

import com.lian.marketing.paymentmicroservice.domain.api.IPaymentServicePort;
import com.lian.marketing.paymentmicroservice.domain.model.Payment;
import com.lian.marketing.paymentmicroservice.domain.spi.IPaymentPersistencePort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class PaymentUseCase implements IPaymentServicePort {

    private final IPaymentPersistencePort paymentPersistencePort;

    @Override
    public void createPaymentFromTransaction(Payment payment) {
        paymentPersistencePort.savePayment(payment);
    }
}
