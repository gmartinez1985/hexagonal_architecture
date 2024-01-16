package com.gfmartinez.hexagonalarchitecture.mapper;

import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.entity.Incidence;
import com.gfmartinez.hexagonalarchitecture.dto.CreateIncidenceCommandAnnotatedDto;
import com.gfmartinez.hexagonalarchitecture.dto.CreateIncidenceResponseAnnotatedDto;
import com.gfmartinez.hexagonalarchitecture.model.dto.CreateIncidenceCommandDto;
import com.gfmartinez.hexagonalarchitecture.model.dto.CreateIncidenceResponseDto;

//@Mapper
public interface CreateIncidenceMapper {

  CreateIncidenceCommandDto toDomainDto(CreateIncidenceCommandAnnotatedDto inDto);

  CreateIncidenceResponseAnnotatedDto fromDomainDto(CreateIncidenceResponseDto inDto);

  CreateIncidenceResponseAnnotatedDto fromEvent(Incidence incidence);
}
