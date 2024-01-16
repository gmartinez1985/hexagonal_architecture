package com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.shared.valueobjects;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.BaseId;
import java.util.UUID;

public class IncidenceId extends BaseId<UUID> {

  public IncidenceId(UUID value) {
    super(value);
  }
}
