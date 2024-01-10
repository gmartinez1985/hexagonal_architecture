package com.gfmartinez.hexagonalarchitecture.domain.application.port.in.service;

import com.gfmartinez.hexagonalarchitecture.domain.application.model.dto.create.CreateIncidenceCommandDto;
import com.gfmartinez.hexagonalarchitecture.domain.application.model.dto.create.CreateIncidenceResponseDto;

public interface CreateIncidenceUseCase {
//  IncidenceCreatedEvent createIncidenceWithAttachment(IncidenceHeader header, IncidenceDescription description, IncidenceSeverity severity,
//      ReporterId reporterId, ClientId clientId, AttachmentId attachmentId, AttachmentFileName fileName, AttachmentFormat format,
//      AttachmentSize size, AttachmentUri uri);

  // CreateIncidenceResponseDto createIncidenceWithAttachment(@Valid CreateIncidenceCommandDto createIncidenceCommand);
  CreateIncidenceResponseDto createIncidenceWithAttachment(CreateIncidenceCommandDto createIncidenceCommand);
}
