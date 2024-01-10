package com.gfmartinez.hexagonalarchitecture.dto;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IncidenceQueryDto {
  @NotNull
  private final UUID incidenceId;

}
