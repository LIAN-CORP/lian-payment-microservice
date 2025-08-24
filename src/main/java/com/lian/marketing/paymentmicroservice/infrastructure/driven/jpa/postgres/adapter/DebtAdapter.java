package com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.adapter;

import com.lian.marketing.paymentmicroservice.domain.model.ContentPage;
import com.lian.marketing.paymentmicroservice.domain.model.Debt;
import com.lian.marketing.paymentmicroservice.domain.spi.IDebtPersistencePort;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.entity.DebtEntity;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.mapper.IDebtEntityMapper;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.repository.IDebtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
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

    @Override
    public boolean existsAndActiveByDebtAndClientId(UUID debtId, UUID clientId) {
        return debtRepository.existsAndActiveByDebtAndClientId(debtId, clientId);
    }

    @Override
    public Optional<Debt> findById(UUID debtId) {
        return debtRepository.findById(debtId).map(debtEntityMapper::toModelFromEntity);
    }

    @Override
    public ContentPage<Debt> findActiveDebts(int page, int size, boolean dateAsc) {
        Sort sort = dateAsc ? Sort.by("createdAt").ascending() : Sort.by("createdAt").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<DebtEntity> debtsEntity = debtRepository.findAll(pageable);
        List<Debt> debts = debtEntityMapper.toModeListFromEntityList(debtsEntity.getContent());
        return new ContentPage<>(
                debtsEntity.getTotalPages(),
                debtsEntity.getTotalElements(),
                debtsEntity.getPageable().getPageNumber(),
                debtsEntity.getPageable().getPageSize(),
                debtsEntity.isFirst(),
                debtsEntity.isLast(),
                debts
        );
    }
}
