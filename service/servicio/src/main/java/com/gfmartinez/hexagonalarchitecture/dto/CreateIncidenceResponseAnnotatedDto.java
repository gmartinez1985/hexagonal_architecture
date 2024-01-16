package com.gfmartinez.hexagonalarchitecture.dto;

import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.IncidenceStatus;
import com.gfmartinez.hexagonalarchitecture.model.dto.AttachmentDto;
import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateIncidenceResponseAnnotatedDto {
  @NotNull
  private final UUID incidenceId;
  @NotNull
  private final short version;
  @NotNull
  private final ZonedDateTime creationDate;
  @NotNull
  private final IncidenceStatus status;


  private final String header;
  private final String description;
  private final UUID reporterId;
  private final UUID clientId;
  private final AttachmentDto attachment;
}
