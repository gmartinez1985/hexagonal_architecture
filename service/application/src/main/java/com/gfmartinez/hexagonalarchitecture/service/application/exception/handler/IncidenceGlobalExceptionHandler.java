package com.gfmartinez.hexagonalarchitecture.service.application.exception.handler;

import com.gfmartinez.hexagonalarchitecture.domain.model.exception.IncidenceDomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
// TODO: To see how this has been moved to the common project
public class IncidenceGlobalExceptionHandler {

  @ResponseBody
  @ExceptionHandler(value = {IncidenceDomainException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDTO handleException(IncidenceDomainException incidenceDomainException) {
    log.error(incidenceDomainException.getMessage(), incidenceDomainException);
    return ErrorDTO.builder()
        .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
        .message(incidenceDomainException.getMessage())
        .build();
  }
}
