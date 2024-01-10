package com.gfmartinez.hexagonalarchitecture.inport;

import com.gfmartinez.hexagonalarchitecture.dto.CreateIncidenceCommandAnnotatedDto;
import com.gfmartinez.hexagonalarchitecture.dto.CreateIncidenceResponseAnnotatedDto;
import jakarta.validation.Valid;

public interface ICreateIncidenceHandler {
  public CreateIncidenceResponseAnnotatedDto execute(@Valid
      CreateIncidenceCommandAnnotatedDto createIncidenceCommand);

}
