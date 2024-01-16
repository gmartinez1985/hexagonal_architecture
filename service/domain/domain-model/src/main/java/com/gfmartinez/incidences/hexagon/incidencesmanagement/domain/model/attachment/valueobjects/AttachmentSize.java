package com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.attachment.valueobjects;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.BaseNonNegativeNumber;

public class AttachmentSize extends BaseNonNegativeNumber<Integer> {
  public AttachmentSize(Integer value) {
    super(value);
  }

}
