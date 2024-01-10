package com.gfmartinez.hexagonalarchitecture.domain.application.model.dto.create;

import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceSeverity;
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
