package com.enterprise.ppardal.infrastructure.adapter.messaging.kafka;

import com.enterprise.ppardal.domain.event.DomainEvent;
import com.enterprise.ppardal.domain.event.OrderPaidEvent;
import com.enterprise.ppardal.domain.event.PricePublishedEvent;
import com.enterprise.ppardal.infrastructure.adapter.messaging.kafka.config.KafkaTopicsProperties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class KafkaTopicResolver {

    private final KafkaTopicsProperties topics;

    public String resolve(DomainEvent event) {
        log.info("Resolveing topic for event {}", event.getClass().getSimpleName());
        if (event instanceof PricePublishedEvent) {
            return topics.getPricePublished();
        }
        if (event instanceof OrderPaidEvent) {
            return topics.getOrderPaid();
        }
        
        throw new IllegalArgumentException(
            "No topic configured for event " + event.getClass()
        );
    }
}