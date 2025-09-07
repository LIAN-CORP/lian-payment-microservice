package com.lian.marketing.paymentmicroservice.domain.api;

import com.lian.marketing.paymentmicroservice.domain.model.ActiveDebt;
import com.lian.marketing.paymentmicroservice.domain.model.ContentPage;
import com.lian.marketing.paymentmicroservice.domain.model.Debt;

import java.math.BigDecimal;
import java.util.UUID;

public interface IDebtServicePort {
    void createDebtFromTransaction(Debt debt);
    boolean existsAndActiveByDebtAndClientId(UUID debtId, UUID clientId);
    void updateTotalRemainingAmount(BigDecimal remainingAmount, UUID debtId);
    ContentPage<ActiveDebt> findActiveDebts(int page, int size, boolean dateAsc);
    void existsActiveDebtById(UUID id);
}
