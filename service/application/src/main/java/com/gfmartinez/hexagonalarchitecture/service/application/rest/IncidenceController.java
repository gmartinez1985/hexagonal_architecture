package com.gfmartinez.hexagonalarchitecture.service.application.rest;

import com.gfmartinez.hexagonalarchitecture.dto.CreateIncidenceCommandAnnotatedDto;
import com.gfmartinez.hexagonalarchitecture.dto.CreateIncidenceResponseAnnotatedDto;
import com.gfmartinez.hexagonalarchitecture.inport.ICreateIncidenceHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/v1/incidences", produces = "application/vnd,api.v1+json")
public class IncidenceController {

  private final ICreateIncidenceHandler createIncidenceHandler;

  public IncidenceController(ICreateIncidenceHandler createIncidenceHandler) {
    this.createIncidenceHandler = createIncidenceHandler;
  }

  @PostMapping
  public ResponseEntity<CreateIncidenceResponseAnnotatedDto> createIncidence(
      @RequestBody CreateIncidenceCommandAnnotatedDto createCommand) {
    log.info("Creating incidence for client {} by reporter", createCommand.getClientId(), createCommand.getReporterId());
    CreateIncidenceResponseAnnotatedDto createIncidenceResponse = createIncidenceHandler.execute(createCommand);
    log.info("Incidence created with id: {}", createIncidenceResponse.getIncidenceId());
    return ResponseEntity.ok(createIncidenceResponse);
  }
}
