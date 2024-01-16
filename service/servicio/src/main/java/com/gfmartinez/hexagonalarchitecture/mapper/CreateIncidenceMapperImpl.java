package com.gfmartinez.hexagonalarchitecture.mapper;

import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.entity.Incidence;
import com.gfmartinez.hexagonalarchitecture.dto.CreateIncidenceCommandAnnotatedDto;
import com.gfmartinez.hexagonalarchitecture.dto.CreateIncidenceResponseAnnotatedDto;
import com.gfmartinez.hexagonalarchitecture.model.dto.CreateIncidenceCommandDto;
import com.gfmartinez.hexagonalarchitecture.model.dto.CreateIncidenceResponseDto;
import org.springframework.stereotype.Component;

// TODO: To see how to use MapsStruc here
@Component
public class CreateIncidenceMapperImpl implements CreateIncidenceMapper{

  @Override
  public CreateIncidenceCommandDto toDomainDto(CreateIncidenceCommandAnnotatedDto inDto) {
    return CreateIncidenceCommandDto.builder()
        .header(inDto.getHeader())
        .description(inDto.getDescription())
        .reporterId(inDto.getReporterId())
        .clientId(inDto.getClientId())
        .severity(inDto.getSeverity())
        .build();

  }

  @Override
  public CreateIncidenceResponseAnnotatedDto fromDomainDto(CreateIncidenceResponseDto inDto) {
    return CreateIncidenceResponseAnnotatedDto.builder()
        .incidenceId(inDto.getIncidenceId())
        .header(inDto.getHeader())
        .description(inDto.getDescription())
        .build();
  }

  @Override
  public CreateIncidenceResponseAnnotatedDto fromEvent(Incidence incidence) {
    return null;
  }
}
