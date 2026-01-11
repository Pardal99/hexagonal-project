package com.enterprise.ppardal.infrastructure.adapter.messaging.kafka;

import org.springframework.kafka.core.KafkaTemplate;

import com.enterprise.ppardal.application.port.DomainEventPublisher;
import com.enterprise.ppardal.domain.event.DomainEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class KafkaDomainEventPublisher implements DomainEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaTopicResolver topicResolver;

    @Override
    public void publish(DomainEvent event) {
        log.info("Publishing event {} to kafka topic {}", event.getClass().getSimpleName(),
                topicResolver.resolve(event));
        kafkaTemplate.send(
                topicResolver.resolve(event),
                event.getKey(),
                event);
    }

}
