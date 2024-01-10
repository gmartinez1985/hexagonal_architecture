package com.gfmartinez.hexagonalarchitecture.domain.model.valueobject;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.BaseId;
import java.util.UUID;

public class ReportId extends BaseId<UUID> {

  public ReportId(UUID value) {
    super(value);
  }
}
