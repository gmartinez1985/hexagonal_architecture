package com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects;

import com.gfmartinez.hexagonalarchitecture.domain.valueobject.BaseId;
import java.util.UUID;

public class ReportId extends BaseId<UUID> {

  public ReportId(UUID value) {
    super(value);
  }
}
