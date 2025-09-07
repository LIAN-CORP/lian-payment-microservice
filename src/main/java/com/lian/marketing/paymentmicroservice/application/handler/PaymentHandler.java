package com.lian.marketing.paymentmicroservice.application.handler;

import com.lian.marketing.paymentmicroservice.application.dto.request.CreatePaymentRequest;
import com.lian.marketing.paymentmicroservice.application.mapper.IPaymentMapper;
import com.lian.marketing.paymentmicroservice.domain.api.IPaymentServicePort;
import com.lian.marketing.paymentmicroservice.domain.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentHandler {

    private final IPaymentMapper paymentMapper;
    private final IPaymentServicePort paymentServicePort;

    public void createPaymentFromTransaction(CreatePaymentRequest request) {
        paymentServicePort.createPaymentFromTransaction(paymentMapper.toModelFromRequest(request));
    }

    public void createPaymentDebt(CreatePaymentRequest request) {
        paymentServicePort.createPaymentDebt(paymentMapper.toModelFromRequest(request));
    }

    public List<Payment> findDebtPaymentsByDebtId(UUID debtId) {
        return paymentServicePort.findDebtPaymentsByDebtId(debtId);
    }
}
