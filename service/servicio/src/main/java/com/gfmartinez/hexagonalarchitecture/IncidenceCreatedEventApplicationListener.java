package com.gfmartinez.hexagonalarchitecture;

import com.gfmartinez.hexagonalarchitecture.domain.model.event.IncidenceCreatedEvent;
import com.gfmartinez.hexagonalarchitecture.outport.message.publisher.IncidenceCreatedNotificationRequestMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class IncidenceCreatedEventApplicationListener {
  private final IncidenceCreatedNotificationRequestMessagePublisher incidenceCreatedNotificationRequestMessagePublisher;

  public IncidenceCreatedEventApplicationListener(
      IncidenceCreatedNotificationRequestMessagePublisher incidenceCreatedNotificationRequestMessagePublisher) {
    this.incidenceCreatedNotificationRequestMessagePublisher = incidenceCreatedNotificationRequestMessagePublisher;
  }

  @TransactionalEventListener
  void process(IncidenceCreatedEvent incidenceCreatedEvent) {
    incidenceCreatedNotificationRequestMessagePublisher.publish(incidenceCreatedEvent);
  }
}
