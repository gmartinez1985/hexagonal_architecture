package com.gfmartinez.hexagonalarchitecture;

import com.gfmartinez.hexagonalarchitecture.domain.event.publisher.DomainEventPublisher;
import com.gfmartinez.hexagonalarchitecture.domain.model.event.IncidenceCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplicationDomainEventPublisher implements ApplicationEventPublisherAware,
    DomainEventPublisher<IncidenceCreatedEvent> {

  private ApplicationEventPublisher applicationEventPublisher;
  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @Override
  public void publish(IncidenceCreatedEvent domainEvent) {
    this.applicationEventPublisher.publishEvent(domainEvent);
    log.info("IncidenceCreatedEvent is published for incidence id: {}", domainEvent.getIncidence().getId().getValue());
  }
}
