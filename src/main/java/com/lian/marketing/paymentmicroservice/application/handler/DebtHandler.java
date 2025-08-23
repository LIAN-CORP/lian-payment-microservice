package com.lian.marketing.paymentmicroservice.application.handler;

import com.lian.marketing.paymentmicroservice.application.dto.request.CreateDebtRequest;
import com.lian.marketing.paymentmicroservice.application.mapper.IDebtMapper;
import com.lian.marketing.paymentmicroservice.domain.api.IDebtServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DebtHandler {

    private final IDebtServicePort debtServicePort;
    private final IDebtMapper debtMapper;

    public void createDebt(CreateDebtRequest request) {
        debtServicePort.createDebtFromTransaction(debtMapper.toModelFromRequest(request));
    }
}
