package com.lian.marketing.paymentmicroservice.configuration;

import com.lian.marketing.paymentmicroservice.domain.api.IDebtServicePort;
import com.lian.marketing.paymentmicroservice.domain.api.usecase.DebtUseCase;
import com.lian.marketing.paymentmicroservice.domain.spi.IDebtPersistencePort;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.adapter.DebtAdapter;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.mapper.IDebtEntityMapper;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.repository.IDebtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DebtBeanConfiguration {

    private final IDebtRepository debtRepository;
    private final IDebtEntityMapper debtEntityMapper;

    @Bean
    public IDebtPersistencePort debtPersistencePort() {
        return new DebtAdapter(debtRepository, debtEntityMapper);
    }

    @Bean
    public IDebtServicePort debtServicePort() {
        return new DebtUseCase(debtPersistencePort());
    }

}
