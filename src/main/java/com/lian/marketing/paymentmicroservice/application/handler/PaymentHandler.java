package com.lian.marketing.paymentmicroservice.application.handler;

import com.lian.marketing.paymentmicroservice.application.dto.request.CreatePaymentRequest;
import com.lian.marketing.paymentmicroservice.application.mapper.IPaymentMapper;
import com.lian.marketing.paymentmicroservice.domain.api.IPaymentServicePort;
import com.lian.marketing.paymentmicroservice.domain.api.usecase.PaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentHandler {

    private final IPaymentMapper paymentMapper;
    private final IPaymentServicePort paymentServicePort;

    public void createPaymentFromTransaction(CreatePaymentRequest request) {
        paymentServicePort.createPaymentFromTransaction(paymentMapper.toModelFromRequest(request));
    }

}
