package com.gfmartinez.hexagonalarchitecture.domain.model.valueobject;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.BaseId;
import java.util.UUID;

public class UserId extends BaseId<UUID> {

  public UserId(UUID value) {
    super(value);
  }
}
