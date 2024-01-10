package com.gfmartinez.hexagonalarchitecture.service;

import com.gfmartinez.hexagonalarchitecture.ApplicationDomainEventPublisher;
import com.gfmartinez.hexagonalarchitecture.dto.CreateIncidenceCommandAnnotatedDto;
import com.gfmartinez.hexagonalarchitecture.dto.CreateIncidenceResponseAnnotatedDto;
import com.gfmartinez.hexagonalarchitecture.domain.model.event.IncidenceCreatedEvent;
import com.gfmartinez.hexagonalarchitecture.inport.ICreateIncidenceHandler;
import com.gfmartinez.hexagonalarchitecture.mapper.CreateIncidenceMapper;
import com.gfmartinez.hexagonalarchitecture.model.dto.CreateIncidenceCommandDto;
import com.gfmartinez.hexagonalarchitecture.model.dto.CreateIncidenceResponseDto;
import com.gfmartinez.hexagonalarchitecture.outport.message.publisher.IncidenceCreatedNotificationRequestMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
class CreateIncidenceHandler implements ICreateIncidenceHandler {

  private final CreateIncidenceUseCaseImpl createIncidenceUseCase;
  private final CreateIncidenceMapper mapper;

  private final ApplicationDomainEventPublisher applicationDomainEventPublisher;

  public CreateIncidenceHandler(CreateIncidenceUseCaseImpl createIncidenceUseCase,
      CreateIncidenceMapper mapper, ApplicationDomainEventPublisher applicationDomainEventPublisher) {
    this.createIncidenceUseCase = createIncidenceUseCase;
    this.mapper = mapper;
    this.applicationDomainEventPublisher = applicationDomainEventPublisher;
  }

//  SIN EVENT LISTENER TRANSACTIONAL
  @Override
  @Transactional
  // Puede que lo siguiente sea necesario para que la transacción siga comportándose como tal dentro del .execute del componente que no es un Bean
  //@Transactional(propagation = Propagation.REQUIRES_NEW)
  public CreateIncidenceResponseAnnotatedDto execute(
      CreateIncidenceCommandAnnotatedDto createIncidenceCommand) {
    CreateIncidenceCommandDto domainDto = mapper.toDomainDto(createIncidenceCommand);
    CreateIncidenceResponseDto result = createIncidenceUseCase.execute(domainDto);
    return mapper.fromDomainDto(result);
  }

  // CON EVENT LISTENER TRANSACTIONAL
//  @Override
//  @Transactional
//  // Puede que lo siguiente sea necesario para que la transacción siga comportándose como tal dentro del .execute del componente que no es un Bean
//  //@Transactional(propagation = Propagation.REQUIRES_NEW)
//  public CreateIncidenceResponseAnnotatedDto execute(
//      CreateIncidenceCommandAnnotatedDto createIncidenceCommand) {
//    CreateIncidenceCommandDto domainDto = mapper.toDomainDto(createIncidenceCommand);
//    IncidenceCreatedEvent incidenceCreatedEvent = createIncidenceUseCase.execute(domainDto);
//    // TODO: Mapper que conviertda de DomainEvent a ServiceEvent
//    applicationDomainEventPublisher.publish(incidenceCreatedEvent);
//    return mapper.fromEvent(incidenceCreatedEvent.getIncidence());
//  }

}
