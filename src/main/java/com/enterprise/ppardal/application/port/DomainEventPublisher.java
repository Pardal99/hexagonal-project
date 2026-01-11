package com.enterprise.ppardal.application.port;

import com.enterprise.ppardal.domain.event.DomainEvent;

public interface DomainEventPublisher {

    void publish(DomainEvent event);
    
}