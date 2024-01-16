package com.gfmartinez.hexagonalarchitecture.repository;

import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.entity.Incidence;

public interface IncidenceRepository {
  Incidence save(Incidence incidence);

}
