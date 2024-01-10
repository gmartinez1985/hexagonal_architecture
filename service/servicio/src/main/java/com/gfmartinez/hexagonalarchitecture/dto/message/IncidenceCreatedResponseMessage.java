package com.gfmartinez.hexagonalarchitecture.dto.message;

import java.time.Instant;
import java.util.UUID;

public class IncidenceCreatedResponseMessage {
  private String id;
  private String sagaId;
  private UUID incidenceId;

  private UUID reporterId;

  private Instant createdAt;

}
