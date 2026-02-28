package com.lian.marketing.paymentmicroservice.application.handler;

import com.lian.marketing.paymentmicroservice.application.dto.request.CreateDebtRequest;
import com.lian.marketing.paymentmicroservice.application.mapper.IDebtMapper;
import com.lian.marketing.paymentmicroservice.domain.api.IDebtServicePort;
import com.lian.marketing.paymentmicroservice.domain.model.ActiveDebt;
import com.lian.marketing.paymentmicroservice.domain.model.ContentPage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DebtHandler {

    private final IDebtServicePort debtServicePort;
    private final IDebtMapper debtMapper;

    public void createDebt(CreateDebtRequest request) {
        debtServicePort.createDebtFromTransaction(debtMapper.toModelFromRequest(request));
    }

    public ContentPage<ActiveDebt> findActiveDebts(int page, int size, boolean dateAsc) {
        return debtServicePort.findActiveDebts(page, size, dateAsc);
    }

    public Boolean hasActiveDebtByClientId(UUID clientId) {
        return debtServicePort.hasAciveDebtByClientId(clientId);
    }
}
