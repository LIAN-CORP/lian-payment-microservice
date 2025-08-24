package com.lian.marketing.paymentmicroservice.domain.api;

import com.lian.marketing.paymentmicroservice.domain.model.Debt;

import java.math.BigDecimal;
import java.util.UUID;

public interface IDebtServicePort {
    void createDebtFromTransaction(Debt debt);
    boolean existsAndActive(UUID debtId);
    void updateTotalRemainingAmount(BigDecimal remainingAmount, UUID debtId);
}
