package com.lian.marketing.paymentmicroservice.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientBeanConfiguration {

    @Value("${url.transaction.api}")
    private String transactionApi;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(transactionApi)
                .build();
    }

}
