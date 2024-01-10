package com.gfmartinez.hexagonalarchitecture.domain.application.model.dto.create;

import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceStatus;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateIncidenceResponseDto {
  //@NotNull
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
