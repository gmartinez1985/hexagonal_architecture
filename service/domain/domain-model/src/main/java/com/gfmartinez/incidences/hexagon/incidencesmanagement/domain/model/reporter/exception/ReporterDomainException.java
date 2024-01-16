package com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.reporter.exception;

import com.gfmartinez.hexagonalarchitecture.domain.exception.DomainException;

public class ReporterDomainException extends DomainException {
  public ReporterDomainException(String message) {
    super(message);
  }

  public ReporterDomainException(String message, Throwable cause) {
    super(message, cause);
  }
}