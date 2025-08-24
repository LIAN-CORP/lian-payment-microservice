package com.lian.marketing.paymentmicroservice.domain.spi;

import com.lian.marketing.paymentmicroservice.domain.model.ContentPage;
import com.lian.marketing.paymentmicroservice.domain.model.Debt;

import java.util.Optional;
import java.util.UUID;

public interface IDebtPersistencePort {
    void saveDebt(Debt debt);
    Optional<Debt> findActiveDebtByClientId(UUID clientId);
    boolean existsAndActiveByDebtAndClientId(UUID debtId, UUID clientId);
    Optional<Debt> findById(UUID debtId);
    ContentPage<Debt> findActiveDebts(int page, int size, boolean dateAsc);
    String getClientNameByIdFromTransaction(UUID clientId);
}
