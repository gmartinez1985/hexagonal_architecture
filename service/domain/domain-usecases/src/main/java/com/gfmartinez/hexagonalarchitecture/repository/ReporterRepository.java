package com.gfmartinez.hexagonalarchitecture.repository;

import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Reporter;
import java.util.Optional;
import java.util.UUID;

public interface ReporterRepository {
  Optional<Reporter> findById(UUID reporterId);
}
