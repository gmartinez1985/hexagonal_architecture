package com.gfmartinez.hexagonalarchitecture.service.application.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
//TODO: To move it to the common
public class ErrorDTO {
  private final String code;
  private final String message;
}
