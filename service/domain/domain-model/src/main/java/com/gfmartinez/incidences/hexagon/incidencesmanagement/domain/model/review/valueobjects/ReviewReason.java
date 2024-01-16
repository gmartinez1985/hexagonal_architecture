package com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.review.valueobjects;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.SizeLimitedString;

public class ReviewReason extends SizeLimitedString {
  private static final int REASON_MAX_SIZE = 500;
  public ReviewReason(String value) {
    super(value, REASON_MAX_SIZE);
  }
}
