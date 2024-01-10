package com.gfmartinez.hexagonalarchitecture.domain.model.valueobject;

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