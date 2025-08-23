package com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.adapter;

import com.lian.marketing.paymentmicroservice.domain.model.Debt;
import com.lian.marketing.paymentmicroservice.domain.spi.IDebtPersistencePort;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.mapper.IDebtEntityMapper;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.repository.IDebtRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class DebtAdapter implements IDebtPersistencePort {

    private final IDebtRepository debtRepository;
    private final IDebtEntityMapper debtEntityMapper;

    @Override
    public void saveDebt(Debt debt) {
        debtRepository.save(debtEntityMapper.toEntityFromModel(debt));
    }

    @Override
    public Optional<Debt> findActiveDebtByClientId(UUID clientId) {
        return debtRepository.findActiveDebtByClientId(clientId).map(debtEntityMapper::toModelFromEntity);
    }
}
