package com.gfmartinez.hexagonalarchitecture.domain.model.valueobject;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.SizeLimitedString;

public class IncidenceDescription extends SizeLimitedString {
  private static final int DESCRIPTION_MAX_SIZE = 100;
  public IncidenceDescription(String value) {
    super(value, DESCRIPTION_MAX_SIZE);
  }
}
