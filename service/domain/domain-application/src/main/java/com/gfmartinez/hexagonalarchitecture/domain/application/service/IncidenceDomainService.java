package com.gfmartinez.hexagonalarchitecture.domain.application.service;

import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Incidence;
import com.gfmartinez.hexagonalarchitecture.domain.model.event.IncidenceCancelledEvent;
import com.gfmartinez.hexagonalarchitecture.domain.model.event.IncidenceCreatedEvent;

public interface IncidenceDomainService {
  IncidenceCreatedEvent createIncidence(Incidence incidence);

//  IncidenceApprovedEvent approveIncidence(Incidence incidence);

//  IncidenceAssignedEvent assignIncidence(Incidence incidence, Repairer repairer);

  IncidenceCancelledEvent cancelIncidence(Incidence incidence);

//  IncidenceDeletedEvent deleteIncidence(Incidence incidence);

//  IncidenceFisnihedEvent finishIncidence(Incidence incidence);

//  IncidenceIncompletedEvent markAsIncompletedIncidence(Incidence incidence, ReviewReason reason);

//  IncidenceRejectedEvent rejectIncidence(Incidence incidence, ReviewReason reason);
}
