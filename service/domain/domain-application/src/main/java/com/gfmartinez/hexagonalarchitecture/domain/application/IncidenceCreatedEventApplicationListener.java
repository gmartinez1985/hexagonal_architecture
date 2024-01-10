package com.gfmartinez.hexagonalarchitecture.domain.application;

import com.gfmartinez.hexagonalarchitecture.domain.application.port.out.message.publisher.incidence.IncidenceCreatedMessagePublisher;
import com.gfmartinez.hexagonalarchitecture.domain.model.event.IncidenceCreatedEvent;

// @Component
// @Sl4j
public class IncidenceCreatedEventApplicationListener {

  private final IncidenceCreatedMessagePublisher incidenceCreatedMessagePublisher;

  public IncidenceCreatedEventApplicationListener(
      IncidenceCreatedMessagePublisher incidenceCreatedMessagePublisher) {
    this.incidenceCreatedMessagePublisher = incidenceCreatedMessagePublisher;
  }

  //@TransactionalEventListener
  void process(IncidenceCreatedEvent incidenceCreatedEvent) {

  }
}

