package com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.adapter;

import com.lian.marketing.paymentmicroservice.domain.constant.ExceptionConstants;
import com.lian.marketing.paymentmicroservice.domain.exception.ClientDoNotExistsException;
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
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class DebtAdapter implements IDebtPersistencePort {

    private final IDebtRepository debtRepository;
    private final IDebtEntityMapper debtEntityMapper;
    private final WebClient webClient;

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
        Sort sort = dateAsc ? Sort.by("created_at").ascending() : Sort.by("created_at").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<DebtEntity> debtsEntity = debtRepository.findActiveDebts(pageable);
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

    @Override
    public String getClientNameByIdFromTransaction(UUID clientId) {
        return webClient.get()
                .uri("/client/name/{clientId}", clientId)
                .retrieve()
                .onStatus(HttpStatus.NOT_FOUND::equals, response -> Mono.error(new ClientDoNotExistsException(ExceptionConstants.CLIENT_DO_NOT_EXISTS)))
                .bodyToMono(String.class)
                .block();
    }
}
