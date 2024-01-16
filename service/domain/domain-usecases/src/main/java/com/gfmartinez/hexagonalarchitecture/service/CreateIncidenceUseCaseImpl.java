package com.gfmartinez.hexagonalarchitecture.service;

import com.gfmartinez.hexagonalarchitecture.model.dto.CreateIncidenceCommandDto;
import com.gfmartinez.hexagonalarchitecture.model.dto.CreateIncidenceResponseDto;
import com.gfmartinez.hexagonalarchitecture.model.mapper.IncidenceDataMapperFactory;
import com.gfmartinez.hexagonalarchitecture.outport.message.publisher.IncidenceCreatedNotificationRequestMessagePublisher;
import com.gfmartinez.hexagonalarchitecture.repository.IncidenceRepository;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.entity.Incidence;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.event.IncidenceCreatedEvent;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.exception.IncidenceDomainException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

public class CreateIncidenceUseCaseImpl {

  private final IncidenceRepository incidenceRepository;
  private final IncidenceDataMapperFactory incidenceDataMapperFactory;

  private final IncidenceCreatedNotificationRequestMessagePublisher incidenceCreatedNotificationRequestMessagePublisher;

  private static final String UTC = "UTC";

  // TODO: Crear en common una clase abstracta que simplemente reciba inyectado el Logger. De esta manera todo Service puede extenderlo para usar el log
  //private final DomainLogger domainLogger;

  public CreateIncidenceUseCaseImpl(
      IncidenceRepository incidenceRepository,
      IncidenceDataMapperFactory incidenceDataMapperFactory,
      IncidenceCreatedNotificationRequestMessagePublisher incidenceCreatedNotificationRequestMessagePublisher) {
    this.incidenceRepository = incidenceRepository;
    this.incidenceDataMapperFactory = incidenceDataMapperFactory;
    this.incidenceCreatedNotificationRequestMessagePublisher = incidenceCreatedNotificationRequestMessagePublisher;
  }


  public CreateIncidenceResponseDto execute(
      CreateIncidenceCommandDto createIncidenceCommand) {
//    checkReporter(createIncidenceCommand.getReporterId());
    // TODO: checkClient
    Incidence incidence = incidenceDataMapperFactory.createIncidenceCommandDtoToIncidence(createIncidenceCommand);
    Incidence incidenceResult = saveIncidence(incidence);
    IncidenceCreatedEvent incidenceCreatedEvent = new IncidenceCreatedEvent(incidenceResult, ZonedDateTime.now(ZoneId.of(UTC)));
    incidenceCreatedNotificationRequestMessagePublisher.publish(incidenceCreatedEvent);
    return incidenceDataMapperFactory.incidenceToCreateIncidenceResponseDto(incidenceResult);
  }

//  private void checkReporter(UUID reporterId) {
//    reporterRepository.findById(reporterId).orElseThrow(() -> {
//      // TODO: log error
//      return new ReporterDomainException("Reporter not found");
//    });
//  }

  private Incidence saveIncidence(Incidence incidence) {
    Incidence incidenceResult = incidenceRepository.save(incidence);
    if (Objects.isNull(incidenceResult)) {
      // TODO: Log error
      throw new IncidenceDomainException("Could not save incidence!");
    }
    // TODO: Log info
    return incidenceResult;
  }
}
