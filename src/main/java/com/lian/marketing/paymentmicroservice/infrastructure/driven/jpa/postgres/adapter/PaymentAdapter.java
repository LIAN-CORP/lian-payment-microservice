package com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.adapter;

import com.lian.marketing.paymentmicroservice.domain.model.Payment;
import com.lian.marketing.paymentmicroservice.domain.spi.IPaymentPersistencePort;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.mapper.IPaymentEntityMapper;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.repository.IPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class PaymentAdapter implements IPaymentPersistencePort {

    private final IPaymentEntityMapper paymentEntityMapper;
    private final IPaymentRepository paymentRepository;
    private final WebClient webClient;

    @Override
    public void savePayment(Payment payment) {
        paymentRepository.save(paymentEntityMapper.toEntityFromModel(payment));
    }

    @Override
    public boolean clientExists(UUID clientId) {
        return webClient.get()
                .uri("/client/exists/{clientId}", clientId)
                .retrieve()
                .bodyToMono(Boolean.class)
                .blockOptional()
                .orElse(false);
    }

    @Override
    public List<Payment> findAllByDebtId(UUID debtId) {
        return paymentRepository.findByDebtId(debtId)
          .stream()
          .map(paymentEntityMapper::toModelFromEntity)
          .toList();
    }
}
