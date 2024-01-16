package com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.BaseId;
import java.util.UUID;

public class RepairerId extends BaseId<UUID> {

  public RepairerId(UUID value) {
    super(value);
  }
}
