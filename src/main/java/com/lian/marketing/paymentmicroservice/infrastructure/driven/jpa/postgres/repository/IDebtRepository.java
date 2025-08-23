package com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.repository;

import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.entity.DebtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IDebtRepository extends JpaRepository<DebtEntity, UUID> {
    @Query(value = "SELECT * FROM public.Debt WHERE status = 'PENDING' AND clientId = :clientId", nativeQuery = true)
    Optional<DebtEntity> findActiveDebtByClientId(UUID clientId);
}
