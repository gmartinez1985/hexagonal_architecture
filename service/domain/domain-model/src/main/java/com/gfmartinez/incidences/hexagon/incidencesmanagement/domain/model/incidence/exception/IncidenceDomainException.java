package com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.exception;

import com.gfmartinez.hexagonalarchitecture.domain.exception.DomainException;

public class IncidenceDomainException extends DomainException {
  public IncidenceDomainException(String message) {
    super(message);
  }

  public IncidenceDomainException(String message, Throwable cause) {
    super(message, cause);
  }
}