package com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.BaseId;
import java.util.UUID;

public class ClientId extends BaseId<UUID> {

  public ClientId(UUID value) {
    super(value);
  }
}
