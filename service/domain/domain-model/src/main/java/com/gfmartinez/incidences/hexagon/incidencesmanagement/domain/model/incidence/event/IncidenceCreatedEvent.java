package com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.event;

import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.entity.Incidence;
import java.time.ZonedDateTime;

public class IncidenceCreatedEvent extends IncidenceEvent {

  public IncidenceCreatedEvent(Incidence incidence, ZonedDateTime creationDate) {
    super(incidence, creationDate);
  }
}
