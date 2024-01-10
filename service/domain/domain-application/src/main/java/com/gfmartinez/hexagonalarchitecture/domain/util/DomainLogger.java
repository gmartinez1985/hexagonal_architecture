package com.gfmartinez.hexagonalarchitecture.domain.util;

// TODO: Moverlo a la parte core
public interface DomainLogger {
  void logInfo(String message, Object... args);
  void logError(String message, Object... args);

  void logDebug(String message, Object... args);

  void logWarning(String message, Object... args);
}
