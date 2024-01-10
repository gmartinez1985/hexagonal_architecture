package com.gfmartinez.hexagonalarchitecture.domain.application.port.out.repository;

import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Incidence;

public interface IncidenceRepository {
  Incidence save(Incidence incidence);

}
