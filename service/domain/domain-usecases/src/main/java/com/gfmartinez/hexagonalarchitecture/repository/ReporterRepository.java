package com.gfmartinez.hexagonalarchitecture.repository;

import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.reporter.entity.Reporter;
import java.util.Optional;
import java.util.UUID;

public interface ReporterRepository {
  Optional<Reporter> findById(UUID reporterId);
}
