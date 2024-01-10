package com.gfmartinez.hexagonalarchitecture.domain.model.event;

import com.gfmartinez.hexagonalarchitecture.domain.event.DomainEvent;
import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Incidence;
import java.time.ZonedDateTime;

public abstract class IncidenceEvent implements DomainEvent<Incidence> {
  private final Incidence incidence;
  private final ZonedDateTime creationDate;

  public IncidenceEvent(Incidence incidence, ZonedDateTime creationDate) {
    this.incidence = incidence;
    this.creationDate = creationDate;
  }

  public Incidence getIncidence() {
    return incidence;
  }

  public ZonedDateTime getCreationDate() {
    return creationDate;
  }
}
