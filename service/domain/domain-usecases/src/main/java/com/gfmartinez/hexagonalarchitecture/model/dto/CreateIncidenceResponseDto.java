package com.gfmartinez.hexagonalarchitecture.model.dto;

import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.IncidenceStatus;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateIncidenceResponseDto {
  private final UUID incidenceId;
  private final short version;
  private final ZonedDateTime creationDate;
  private final IncidenceStatus status;


  private final String header;
  private final String description;
  private final UUID reporterId;
  private final UUID clientId;
  private final AttachmentDto attachment;
}
