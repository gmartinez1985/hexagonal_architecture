package com.gfmartinez.hexagonalarchitecture.domain.model.exception;

import com.gfmartinez.hexagonalarchitecture.domain.exception.DomainException;

public class ReporterDomainException extends DomainException {
  public ReporterDomainException(String message) {
    super(message);
  }

  public ReporterDomainException(String message, Throwable cause) {
    super(message, cause);
  }
}