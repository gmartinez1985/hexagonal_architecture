package com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.exception;

public class IncidenceTransitionNotAllowedException extends RuntimeException{
  public IncidenceTransitionNotAllowedException(String message) {
    super(message);
  }

}
