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
@Table(name = "debt")
public class DebtEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "remaining_amount")
    private Double remainingAmount;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "client_id")
    private UUID clientId;

    @Column(name = "transaction_id")
    private UUID transactionId;
}
