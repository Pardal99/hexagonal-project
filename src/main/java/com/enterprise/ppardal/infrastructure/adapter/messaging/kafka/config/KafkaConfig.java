package com.enterprise.ppardal.infrastructure.adapter.messaging.kafka.config;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
@EnableConfigurationProperties(KafkaProducerProperties.class)
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, Object> producerFactory(
            KafkaProducerProperties properties) {

        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                properties.getBootstrapServers());
        config.put(ProducerConfig.ACKS_CONFIG,
                properties.getProducer().getAcks());
        config.put(ProducerConfig.RETRIES_CONFIG,
                properties.getProducer().getRetries());
        config.put(ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG,
                properties.getProducer().getDeliveryTimeoutMs());
        config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,
                properties.getProducer().isEnableIdempotence());

        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate(
            ProducerFactory<String, Object> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
    
}
