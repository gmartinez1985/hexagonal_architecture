package com.gfmartinez.hexagonalarchitecture.incidence.service.messaging.publisher.rabbit;

import com.gfmartinez.hexagonalarchitecture.config.IncidenceServiceConfigData;
import com.gfmartinez.hexagonalarchitecture.domain.model.event.IncidenceCreatedEvent;
import com.gfmartinez.hexagonalarchitecture.incidence.service.messaging.mapper.IncidenceMessagingDataMapper;
import com.gfmartinez.hexagonalarchitecture.outport.message.publisher.IncidenceCreatedNotificationRequestMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateIncidenceRabbitMessagePublisher implements
    IncidenceCreatedNotificationRequestMessagePublisher {

  private final IncidenceMessagingDataMapper messagingDataMapper;
  private final IncidenceServiceConfigData incidenceServiceConfigData;

  private final RabbitTemplate rabbitTemplate;

  public CreateIncidenceRabbitMessagePublisher(IncidenceMessagingDataMapper messagingDataMapper,
      IncidenceServiceConfigData incidenceServiceConfigData, RabbitTemplate rabbitTemplate) {
    this.messagingDataMapper = messagingDataMapper;
    this.incidenceServiceConfigData = incidenceServiceConfigData;
    this.rabbitTemplate = rabbitTemplate;
  }



  @Override
  public void publish(IncidenceCreatedEvent domainEvent) {
    String incidenceId = domainEvent.getIncidence().getId().getValue().toString();
    rabbitTemplate.convertAndSend("my_exchange", "my_routing_key", messagingDataMapper.incidenceCreatedEventToString(domainEvent));
  }
}
