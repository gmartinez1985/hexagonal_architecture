package com.gfmartinez.hexagonalarchitecture.domain.model.event;

import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Incidence;
import java.time.ZonedDateTime;

public class IncidenceApprovedEvent extends IncidenceEvent {

  public IncidenceApprovedEvent(Incidence incidence, ZonedDateTime creationDate) {
    super(incidence, creationDate);
  }
}
