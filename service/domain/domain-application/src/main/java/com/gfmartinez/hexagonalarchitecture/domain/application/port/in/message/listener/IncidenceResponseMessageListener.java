package com.gfmartinez.hexagonalarchitecture.domain.application.port.in.message.listener;

import com.gfmartinez.hexagonalarchitecture.domain.application.model.dto.create.CreateIncidenceResponseDto;

// TODO: for SAGA pattern
public interface IncidenceResponseMessageListener {
  void incidenceCreatedCompleted(CreateIncidenceResponseDto createIncidenceResponse);
  void incidenceCreatedCancelled(CreateIncidenceResponseDto createIncidenceResponse);
}
