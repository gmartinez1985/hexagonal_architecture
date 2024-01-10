package com.gfmartinez.hexagonalarchitecture.dto;

import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceSeverity;
import com.gfmartinez.hexagonalarchitecture.model.dto.AttachmentDto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateIncidenceCommandAnnotatedDto {
  @NotNull
  @Size(max = 50)
  private final String header;
  @NotNull
  private final String description;
  @NotNull
  private final UUID reporterId;
  @NotNull
  private final UUID clientId;
  @NotNull
  private final IncidenceSeverity severity;
  @NotNull
  private final AttachmentDto attachment;
}
