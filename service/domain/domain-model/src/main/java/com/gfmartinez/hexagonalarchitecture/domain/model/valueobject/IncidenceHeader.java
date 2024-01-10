package com.gfmartinez.hexagonalarchitecture.domain.model.valueobject;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.SizeLimitedString;

public class IncidenceHeader extends SizeLimitedString {
  private static final int HEADER_MAX_SIZE = 100;
  public IncidenceHeader(String value) {
    super(value, HEADER_MAX_SIZE);
  }
}
