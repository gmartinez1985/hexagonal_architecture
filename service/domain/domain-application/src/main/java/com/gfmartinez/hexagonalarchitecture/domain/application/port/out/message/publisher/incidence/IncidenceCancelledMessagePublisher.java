package com.gfmartinez.hexagonalarchitecture.domain.application.port.out.message.publisher.incidence;

import com.gfmartinez.hexagonalarchitecture.domain.event.publisher.DomainEventPublisher;
import com.gfmartinez.hexagonalarchitecture.domain.model.event.IncidenceCancelledEvent;

public interface IncidenceCancelledMessagePublisher extends
    DomainEventPublisher<IncidenceCancelledEvent> {

}
