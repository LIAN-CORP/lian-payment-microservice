package com.lian.marketing.paymentmicroservice.configuration;

import com.lian.marketing.paymentmicroservice.domain.api.IPaymentServicePort;
import com.lian.marketing.paymentmicroservice.domain.api.usecase.PaymentUseCase;
import com.lian.marketing.paymentmicroservice.domain.spi.IPaymentPersistencePort;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.adapter.PaymentAdapter;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.mapper.IPaymentEntityMapper;
import com.lian.marketing.paymentmicroservice.infrastructure.driven.jpa.postgres.repository.IPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PaymentBeanConfiguration {

    private final IPaymentRepository paymentRepository;
    private final IPaymentEntityMapper paymentEntityMapper;
    private final DebtBeanConfiguration debtBeanConfiguration;
    private final WebClientBeanConfiguration webClientBeanConfiguration;

    @Bean
    public IPaymentPersistencePort paymentPersistencePort() {
        return new PaymentAdapter(paymentEntityMapper, paymentRepository, webClientBeanConfiguration.webClient());
    }

    @Bean
    public IPaymentServicePort paymentServicePort() {
        return new PaymentUseCase(paymentPersistencePort(), debtBeanConfiguration.debtServicePort());
    }

}
