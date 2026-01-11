package com.enterprise.ppardal.infrastructure.adapter.messaging.kafka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "kafka.topics")
@Getter
@Setter
public class KafkaTopicsProperties {
    private String pricePublished;
    private String orderPaid;
}