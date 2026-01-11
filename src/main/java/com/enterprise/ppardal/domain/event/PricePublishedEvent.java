package com.enterprise.ppardal.domain.event;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PricePublishedEvent implements DomainEvent {

    private final Long productId;
    private final BigDecimal price;
    private final String currency;

    @Override
    public String getKey() {
        return productId.toString();
    }
    
}
