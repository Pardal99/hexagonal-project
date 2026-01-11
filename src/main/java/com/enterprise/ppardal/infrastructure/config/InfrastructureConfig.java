package com.enterprise.ppardal.infrastructure.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import com.enterprise.ppardal.application.port.DomainEventPublisher;
import com.enterprise.ppardal.application.port.PricesPersistencePort;
import com.enterprise.ppardal.infrastructure.adapter.api.mapper.PricesApiMapper;
import com.enterprise.ppardal.infrastructure.adapter.messaging.kafka.KafkaDomainEventPublisher;
import com.enterprise.ppardal.infrastructure.adapter.messaging.kafka.KafkaTopicResolver;
import com.enterprise.ppardal.infrastructure.adapter.messaging.kafka.config.KafkaTopicsProperties;
import com.enterprise.ppardal.infrastructure.adapter.messaging.kafka.mapper.KafkaEventMapper;
import com.enterprise.ppardal.infrastructure.adapter.persistence.PricesRepository;
import com.enterprise.ppardal.infrastructure.adapter.persistence.PricesRepositoryAdapter;
import com.enterprise.ppardal.infrastructure.adapter.persistence.mapper.PricesPersistenceMapper;

@Configuration
public class InfrastructureConfig {

    @Bean
    PricesApiMapper pricesApiMapper(ModelMapper modelMapper) {
        return new PricesApiMapper(modelMapper);
    }

    @Bean
    PricesPersistencePort pricesPersistencePort(PricesRepository pricesRepository,
            PricesPersistenceMapper mapper) {
        return new PricesRepositoryAdapter(pricesRepository, mapper);
    }

    @Bean
    PricesPersistenceMapper pricesPersistenceMapper(ModelMapper modelMapper) {
        return new PricesPersistenceMapper(modelMapper);
    }

    @Bean
    DomainEventPublisher domainEventPublisher(KafkaTemplate<String, Object> kafkaTemplate,
            KafkaTopicResolver topicResolver) {
        return new KafkaDomainEventPublisher(kafkaTemplate, topicResolver);
    }

    @Bean
    KafkaTopicResolver kafkaTopicResolver(KafkaTopicsProperties props) {
        return new KafkaTopicResolver(props);
    }

    @Bean
    KafkaEventMapper kafkaEventMapper() {
        return new KafkaEventMapper();
    }

}