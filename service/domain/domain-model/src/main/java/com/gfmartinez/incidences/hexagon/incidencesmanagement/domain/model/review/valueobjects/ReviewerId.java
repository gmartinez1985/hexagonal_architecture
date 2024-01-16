package com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.review.valueobjects;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.BaseId;
import java.util.UUID;

public class ReviewerId extends BaseId<UUID> {

  public ReviewerId(UUID value) {
    super(value);
  }
}
