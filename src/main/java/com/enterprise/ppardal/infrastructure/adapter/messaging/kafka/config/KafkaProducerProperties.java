package com.enterprise.ppardal.infrastructure.adapter.messaging.kafka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ConfigurationProperties(prefix = "kafka")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KafkaProducerProperties {

    private String bootstrapServers;
    private Producer producer;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Producer {
        private String acks;
        private int retries;
        private int deliveryTimeoutMs;
        private boolean enableIdempotence;
    }

}