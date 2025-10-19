package com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.repository;

import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.entity.DebtEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IDebtRepository extends JpaRepository<DebtEntity, UUID> {
    @Query(value = "SELECT * FROM public.Debt WHERE status = 'PENDING' AND client_id = :clientId", nativeQuery = true)
    Optional<DebtEntity> findActiveDebtByClientId(UUID clientId);

    @Query(value = "SELECT EXISTS(SELECT 1 FROM public.Debt WHERE id = :id AND status = 'PENDING' AND client_id = :clientId)", nativeQuery = true)
    boolean existsAndActiveByDebtAndClientId(UUID id, UUID clientId);

    @Query(value = "SELECT * FROM public.Debt WHERE status = 'PENDING'", nativeQuery = true)
    Page<DebtEntity> findActiveDebts(Pageable pageable);

    @Query(value = "SELECT EXISTS(SELECT 1 FROM public.Debt WHERE id = :id AND status = 'PENDING')", nativeQuery = true)
    boolean existsActiveDebtById(UUID id);
}
