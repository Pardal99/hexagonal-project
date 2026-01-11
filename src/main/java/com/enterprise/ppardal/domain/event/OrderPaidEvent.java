package com.enterprise.ppardal.domain.event;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderPaidEvent implements DomainEvent {

    private final Long orderId;
    private final BigDecimal amount;
    private final String paymentMethod;

    @Override
    public String getKey() {
        return orderId.toString();
    }
    
}
