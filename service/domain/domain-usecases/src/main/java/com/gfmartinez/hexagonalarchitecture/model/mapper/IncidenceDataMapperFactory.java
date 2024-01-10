package com.gfmartinez.hexagonalarchitecture.model.mapper;

import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Incidence;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentFileName;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentFormat;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentId;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentSize;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentUri;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.ClientId;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceDescription;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceHeader;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.ReporterId;
import com.gfmartinez.hexagonalarchitecture.model.dto.CreateIncidenceCommandDto;
import com.gfmartinez.hexagonalarchitecture.model.dto.CreateIncidenceResponseDto;

//@Component
public class IncidenceDataMapperFactory {
  public Incidence createIncidenceCommandDtoToIncidence(
      CreateIncidenceCommandDto createIncidenceCommand) {
    // TODO: To create a builder pattern in Incidence and use it here.
    return Incidence.newIncidenceWithAttachment(
        new IncidenceHeader(createIncidenceCommand.getHeader()),
        new IncidenceDescription(createIncidenceCommand.getDescription()),
        new ClientId(createIncidenceCommand.getClientId()),
        createIncidenceCommand.getSeverity(),
        new ReporterId(createIncidenceCommand.getReporterId()),
        new AttachmentId(1L),
        new AttachmentFileName(createIncidenceCommand.getAttachment().getFileName()),
        new AttachmentFormat(createIncidenceCommand.getAttachment().getFormat()),
        new AttachmentSize(createIncidenceCommand.getAttachment().getSize()),
        new AttachmentUri(createIncidenceCommand.getAttachment().getUri()));
  }

  public CreateIncidenceResponseDto incidenceToCreateIncidenceResponseDto(Incidence incidence) {
    return CreateIncidenceResponseDto.builder()
        .incidenceId(incidence.getId().getValue())
        .header(incidence.getHeader().getValue())
        .description(incidence.getDescription().getValue())
        .build();
  }

}
