package com.enterprise.ppardal.support;

import java.util.ArrayList;
import java.util.List;

import com.enterprise.ppardal.application.port.DomainEventPublisher;
import com.enterprise.ppardal.domain.event.DomainEvent;

public class FakeDomainEventPublisher implements DomainEventPublisher {

    private final List<DomainEvent> publishedEvents = new ArrayList<>();

    @Override
    public void publish(DomainEvent event) {
        publishedEvents.add(event);
    }

    public List<DomainEvent> getPublishedEvents() {
        return publishedEvents;
    }

}
