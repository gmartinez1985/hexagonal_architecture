package com.gfmartinez.hexagonalarchitecture.domain.model.valueobject;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.BaseNonNegativeNumber;

public class AttachmentSize extends BaseNonNegativeNumber<Integer> {
  public AttachmentSize(Integer value) {
    super(value);
  }

}
