package com.enterprise.ppardal.infrastructure.adapter.messaging.kafka.mapper;

import com.enterprise.ppardal.domain.event.PricePublishedEvent;
import com.enterprise.ppardal.domain.model.Price;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class KafkaEventMapper {

    public PricePublishedEvent toPricePublishedEvent(Price price) {
        if (price == null) {
            return null;
        }

        return new PricePublishedEvent(
                price.getProductId(),
                price.getPrice(),
                price.getCurrency()
        );
    }
}

