package com.gfmartinez.hexagonalarchitecture.incidence.service.messaging.mapper;

import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Incidence;
import com.gfmartinez.hexagonalarchitecture.domain.model.event.IncidenceCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class IncidenceMessagingDataMapper {
  public String incidenceCreatedEventToString(IncidenceCreatedEvent incidenceCreatedEvent) {
    Incidence incidence = incidenceCreatedEvent.getIncidence();
    return incidence.toString();
  }
}
