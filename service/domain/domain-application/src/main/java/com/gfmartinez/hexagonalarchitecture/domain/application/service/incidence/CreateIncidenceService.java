package com.gfmartinez.hexagonalarchitecture.domain.application.service.incidence;

import com.gfmartinez.hexagonalarchitecture.domain.application.ApplicationDomainEventPublisher;
import com.gfmartinez.hexagonalarchitecture.domain.application.model.dto.create.CreateIncidenceResponseDto;
import com.gfmartinez.hexagonalarchitecture.domain.application.model.mapper.IncidenceDataMapper;
import com.gfmartinez.hexagonalarchitecture.domain.application.port.in.service.CreateIncidenceUseCase;
import com.gfmartinez.hexagonalarchitecture.domain.application.model.dto.create.CreateIncidenceCommandDto;
import com.gfmartinez.hexagonalarchitecture.domain.application.port.out.repository.AttachmentRepository;
import com.gfmartinez.hexagonalarchitecture.domain.application.port.out.repository.IncidenceRepository;
import com.gfmartinez.hexagonalarchitecture.domain.application.port.out.repository.ReporterRepository;
import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Incidence;
import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Reporter;
import com.gfmartinez.hexagonalarchitecture.domain.model.event.IncidenceCreatedEvent;
import com.gfmartinez.hexagonalarchitecture.domain.model.exception.IncidenceDomainException;
import com.gfmartinez.hexagonalarchitecture.domain.model.exception.ReporterDomainException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

//@Service
//@Validated
//@Slf4j
class CreateIncidenceService implements CreateIncidenceUseCase {

  private final IncidenceRepository incidenceRepository;
  private final AttachmentRepository attachmentRepository;
//
  private final ReporterRepository reporterRepository;

  private final IncidenceDataMapper incidenceDataMapper;

  private final ApplicationDomainEventPublisher applicationDomainEventPublisher;


  // TODO: Crear en common una clase abstracta que simplemente reciba inyectado el Logger. De esta
  // manera todo Service puede extenderlo para usar el log
  //private final DomainLogger domainLogger;

    public CreateIncidenceService(
      IncidenceRepository incidenceRepository, AttachmentRepository attachmentRepository,
      ReporterRepository reporterRepository,
        IncidenceDataMapper incidenceDataMapper,
        ApplicationDomainEventPublisher applicationDomainEventPublisher) {
    this.incidenceRepository = incidenceRepository;
    this.attachmentRepository = attachmentRepository;
    this.reporterRepository = reporterRepository;
      this.incidenceDataMapper = incidenceDataMapper;
      this.applicationDomainEventPublisher = applicationDomainEventPublisher;
    }

  @Override
  public CreateIncidenceResponseDto createIncidenceWithAttachment(
      CreateIncidenceCommandDto createIncidenceCommand) {
    Reporter reporter = checkReporter(createIncidenceCommand.getReporterId());
    Incidence incidence = incidenceDataMapper.createIncidenceCommandDtoToIncidence(createIncidenceCommand);
    Incidence incidenceResult = saveIncidence(incidence);
    // Log
    IncidenceCreatedEvent incidenceCreatedEvent = new IncidenceCreatedEvent(incidenceResult, ZonedDateTime.now(
        ZoneId.of("UTC")));
    // Log
    // incidenceCreatedMessagePublisher.publish(incidenceCreatedEvent);
    // ALTERNATIVE
    applicationDomainEventPublisher.publish(incidenceCreatedEvent);
    return incidenceDataMapper.incidenceToCreateIncidenceResponseDto(incidenceCreatedEvent.getIncidence());
  }

  private Reporter checkReporter(UUID reporterId) {
    return reporterRepository.findById(reporterId).orElseThrow(() -> {
      // TODO: log error
      return new ReporterDomainException("");
    });
  }

  private Incidence saveIncidence(Incidence incidence) {
    Incidence incidenceResult = incidenceRepository.save(incidence);
    if(incidenceResult == null) {
      // TODO: Log error
      throw new IncidenceDomainException("Could not save incidence!");
    }
    // TODO: Log info
    return incidenceResult;
  }
}
