package com.gfmartinez.hexagonalarchitecture.domain.model.valueobject;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.BaseNonNegativeNumber;
import java.util.concurrent.TimeUnit;

public class Duration extends BaseNonNegativeNumber<Long> {

  private final TimeUnit timeUnit;
  public Duration(Long value) {
    super(value);
    this.timeUnit = TimeUnit.MINUTES;
  }

  public TimeUnit getTimeUnit() {
    return timeUnit;
  }

  public Long getValue() {
    return value;
  }
}