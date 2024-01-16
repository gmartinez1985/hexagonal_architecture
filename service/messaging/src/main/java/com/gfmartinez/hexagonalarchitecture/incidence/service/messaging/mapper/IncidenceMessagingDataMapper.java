package com.gfmartinez.hexagonalarchitecture.incidence.service.messaging.mapper;

import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.entity.Incidence;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.event.IncidenceCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class IncidenceMessagingDataMapper {
  public String incidenceCreatedEventToString(IncidenceCreatedEvent incidenceCreatedEvent) {
    Incidence incidence = incidenceCreatedEvent.getIncidence();
    return "incidence.toString()";
  }
}
