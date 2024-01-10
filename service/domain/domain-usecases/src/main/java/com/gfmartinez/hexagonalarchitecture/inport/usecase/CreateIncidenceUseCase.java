package com.gfmartinez.hexagonalarchitecture.inport.usecase;

import com.gfmartinez.hexagonalarchitecture.model.dto.CreateIncidenceCommandDto;
import com.gfmartinez.hexagonalarchitecture.model.dto.CreateIncidenceResponseDto;

public interface CreateIncidenceUseCase {

  /**
   * Como entrada se tiene el DTO con los datos proporcionados por el usuario: commandDTO / queryDTO
   * Como salida se tiene el DTO con los datos que, además ha establecido el sistema, debe ver el usuario: responseDTO
   * Internamente se debe hacer uso de un Publisher de eventos para publicar el evento de Incidencia Creada. Esta interfaz debería ser un outport
   */
  public CreateIncidenceResponseDto execute(
      CreateIncidenceCommandDto createIncidenceCommand);
}
