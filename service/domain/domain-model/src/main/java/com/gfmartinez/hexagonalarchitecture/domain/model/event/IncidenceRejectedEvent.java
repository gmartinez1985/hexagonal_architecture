package com.gfmartinez.hexagonalarchitecture.domain.model.event;

import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Incidence;
import java.time.ZonedDateTime;

public class IncidenceRejectedEvent extends IncidenceEvent {

  public IncidenceRejectedEvent(Incidence incidence, ZonedDateTime creationDate) {
    super(incidence, creationDate);
  }
}
