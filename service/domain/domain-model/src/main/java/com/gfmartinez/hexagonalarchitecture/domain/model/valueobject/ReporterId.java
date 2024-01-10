package com.gfmartinez.hexagonalarchitecture.domain.model.valueobject;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.BaseId;
import java.util.UUID;

public class ReporterId extends BaseId<UUID> {

  public ReporterId(UUID value) {
    super(value);
  }
}
