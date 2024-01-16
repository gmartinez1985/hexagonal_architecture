package com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.BaseNonNegativeNumber;

public class Version extends BaseNonNegativeNumber<Short> {

  public Version() {
    super((short)1);
  }

  public void increase() {
    value++;
  }
  public Short getValue() {
    return value;
  }
}