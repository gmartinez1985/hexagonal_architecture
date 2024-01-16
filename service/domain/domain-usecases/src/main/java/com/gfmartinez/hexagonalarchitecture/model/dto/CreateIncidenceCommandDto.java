package com.gfmartinez.hexagonalarchitecture.model.dto;

import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.IncidenceSeverity;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateIncidenceCommandDto {
  private final String header;
  private final String description;
  private final UUID reporterId;
  private final UUID clientId;
  private final IncidenceSeverity severity;
  private final AttachmentDto attachment;
}
