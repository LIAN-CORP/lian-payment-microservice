package com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.adapter;

import com.lian.marketing.paymentmicroservice.domain.model.Payment;
import com.lian.marketing.paymentmicroservice.domain.spi.IPaymentPersistencePort;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.mapper.IPaymentEntityMapper;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.repository.IPaymentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentAdapter implements IPaymentPersistencePort {

    private final IPaymentEntityMapper paymentEntityMapper;
    private final IPaymentRepository paymentRepository;

    @Override
    public void savePayment(Payment payment) {
        paymentRepository.save(paymentEntityMapper.toEntityFromModel(payment));
    }
}
