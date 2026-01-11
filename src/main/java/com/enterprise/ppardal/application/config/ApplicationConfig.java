package com.enterprise.ppardal.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.enterprise.ppardal.application.port.DomainEventPublisher;
import com.enterprise.ppardal.application.port.PricesPersistencePort;
import com.enterprise.ppardal.application.port.PricesServicePort;
import com.enterprise.ppardal.application.service.PricesService;
import com.enterprise.ppardal.infrastructure.adapter.messaging.kafka.mapper.KafkaEventMapper;

@Configuration
public class ApplicationConfig {

    @Bean
    PricesServicePort pricesServicePort(PricesPersistencePort pricesPersistencePort, DomainEventPublisher domainEventPublisher, KafkaEventMapper kafkaEventMapper) {
        return new PricesService(pricesPersistencePort, domainEventPublisher, kafkaEventMapper);
    }

}
