package com.gfmartinez.hexagonalarchitecture.outport.message.publisher;

import com.gfmartinez.hexagonalarchitecture.domain.event.publisher.DomainEventPublisher;
import com.gfmartinez.hexagonalarchitecture.domain.model.event.IncidenceCreatedEvent;

public interface IncidenceCreatedNotificationRequestMessagePublisher extends
    DomainEventPublisher<IncidenceCreatedEvent> {

}
