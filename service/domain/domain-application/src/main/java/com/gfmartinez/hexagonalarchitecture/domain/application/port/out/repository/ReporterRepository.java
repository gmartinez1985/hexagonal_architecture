package com.gfmartinez.hexagonalarchitecture.domain.application.port.out.repository;

import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Reporter;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.ReporterId;
import java.util.Optional;
import java.util.UUID;

public interface ReporterRepository {
  Optional<Reporter> findById(UUID reporterId);
}
