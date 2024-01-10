package com.gfmartinez.hexagonalarchitecture.domain.application.service;

import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Attachment;
import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Incidence;
import com.gfmartinez.hexagonalarchitecture.domain.model.event.IncidenceCancelledEvent;
import com.gfmartinez.hexagonalarchitecture.domain.model.event.IncidenceCreatedEvent;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class IncidenceDomainServiceImpl implements IncidenceDomainService{
  private static final String UTC = "UTC";
  @Override
  public IncidenceCreatedEvent createIncidenceWithAttachment(Incidence incidence, Attachment attachment) {

    return null;
  }

  @Override
  public IncidenceCancelledEvent cancelIncidence(Incidence incidence) {
    incidence.cancel();
    return new IncidenceCancelledEvent(incidence, ZonedDateTime.now(ZoneId.of(UTC)));
  }
}
