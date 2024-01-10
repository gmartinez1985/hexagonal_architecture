package com.gfmartinez.hexagonalarchitecture.inport.message.listener.notification;

import com.gfmartinez.hexagonalarchitecture.model.dto.CreateIncidenceResponseDto;

public interface NotificationResponseMessageListener {
  void incidenceCreated(CreateIncidenceResponseDto createIncidenceResponseDto);
}
