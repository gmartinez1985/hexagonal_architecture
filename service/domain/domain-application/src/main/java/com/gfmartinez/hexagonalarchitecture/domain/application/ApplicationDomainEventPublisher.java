package com.gfmartinez.hexagonalarchitecture.domain.application;

import com.gfmartinez.hexagonalarchitecture.domain.event.publisher.DomainEventPublisher;
import com.gfmartinez.hexagonalarchitecture.domain.model.event.IncidenceCreatedEvent;

//@Component
//@Sl4j
// ESTA DEPENDENCIA ES DE SPRING
public class ApplicationDomainEventPublisher implements ApplicationEventPublisherAware,
    DomainEventPublisher<IncidenceCreatedEvent> {

  private ApplicationEventPublisher applicationEventPublisher;

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @Override
  public void publish(IncidenceCreatedEvent incidenceCreatedEvent) {
    this.applicationEventPublisher.publish(incidenceCreatedEvent);
    // LOG
  }
}
