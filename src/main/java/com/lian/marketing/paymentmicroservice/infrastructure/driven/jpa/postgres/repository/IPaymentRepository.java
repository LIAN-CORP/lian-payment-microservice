package com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.repository;

import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPaymentRepository extends JpaRepository<PaymentEntity, UUID> {
}
