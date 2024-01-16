package com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.user.valueobject;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.BaseId;
import java.util.UUID;

public class UserId extends BaseId<UUID> {

  public UserId(UUID value) {
    super(value);
  }
}
