package com.lian.marketing.paymentmicroservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Payment {
    private UUID id;
    private Integer amount;
    private LocalDateTime paymentDate;
    private PaymentMethod paymentMethod;
    private UUID clientId;
    private UUID transactionId;
    private UUID debtId;
}
