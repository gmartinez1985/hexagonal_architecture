package com.gfmartinez.hexagonalarchitecture.domain.application.port.out.message.publisher.incidence;

import com.gfmartinez.hexagonalarchitecture.domain.event.publisher.DomainEventPublisher;
import com.gfmartinez.hexagonalarchitecture.domain.model.event.IncidenceCreatedEvent;

public interface IncidenceCreatedMessagePublisher extends DomainEventPublisher<IncidenceCreatedEvent> {

}
