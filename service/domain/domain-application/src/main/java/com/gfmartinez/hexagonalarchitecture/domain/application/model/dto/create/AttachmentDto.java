package com.gfmartinez.hexagonalarchitecture.domain.application.model.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AttachmentDto {
  private final String fileName;
  private final String uri;
  private final int size;
  private final String format;

}
