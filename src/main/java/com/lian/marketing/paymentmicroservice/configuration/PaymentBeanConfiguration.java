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
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class PaymentBeanConfiguration {

    private final IPaymentRepository paymentRepository;
    private final IPaymentEntityMapper paymentEntityMapper;
    private final DebtBeanConfiguration debtBeanConfiguration;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8082")
                .build();
    }

    @Bean
    public IPaymentPersistencePort paymentPersistencePort() {
        return new PaymentAdapter(paymentEntityMapper, paymentRepository, webClient());
    }

    @Bean
    public IPaymentServicePort paymentServicePort() {
        return new PaymentUseCase(paymentPersistencePort(), debtBeanConfiguration.debtServicePort());
    }

}
