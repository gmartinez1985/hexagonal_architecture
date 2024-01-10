package com.gfmartinez.hexagonalarchitecture.domain.model.event;

import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Incidence;
import java.time.ZonedDateTime;

public class IncidenceCreatedEvent extends IncidenceEvent {

  public IncidenceCreatedEvent(Incidence incidence, ZonedDateTime creationDate) {
    super(incidence, creationDate);
  }
}
