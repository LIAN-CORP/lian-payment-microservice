package com.lian.marketing.paymentmicroservice.domain.spi;

import com.lian.marketing.paymentmicroservice.domain.model.Debt;

import java.util.Optional;
import java.util.UUID;

public interface IDebtPersistencePort {
    void saveDebt(Debt debt);
    Optional<Debt> findActiveDebtByClientId(UUID clientId);
    boolean existsAndActive(UUID debtId);
    Optional<Debt> findById(UUID debtId);
}
