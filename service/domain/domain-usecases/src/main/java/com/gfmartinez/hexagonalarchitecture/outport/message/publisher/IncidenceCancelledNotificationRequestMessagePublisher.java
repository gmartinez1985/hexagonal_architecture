package com.gfmartinez.hexagonalarchitecture.outport.message.publisher;

import com.gfmartinez.hexagonalarchitecture.domain.event.publisher.DomainEventPublisher;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.event.IncidenceCancelledEvent;

public interface IncidenceCancelledNotificationRequestMessagePublisher extends DomainEventPublisher<IncidenceCancelledEvent> {

}
