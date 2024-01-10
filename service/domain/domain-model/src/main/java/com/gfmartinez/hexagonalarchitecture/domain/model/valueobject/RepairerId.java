package com.gfmartinez.hexagonalarchitecture.domain.model.valueobject;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.BaseId;
import java.util.UUID;

public class RepairerId extends BaseId<UUID> {

  public RepairerId(UUID value) {
    super(value);
  }
}
