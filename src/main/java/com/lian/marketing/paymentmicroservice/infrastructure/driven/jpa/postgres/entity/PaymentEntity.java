package com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, columnDefinition = "numeric(10,2)")
    private Integer amount;

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "client_id", nullable = false)
    private UUID clientId;

    @Column(name = "transaction_id", nullable = false)
    private UUID transactionId;

    @Column(name = "debt_id")
    private UUID debtId;

}
