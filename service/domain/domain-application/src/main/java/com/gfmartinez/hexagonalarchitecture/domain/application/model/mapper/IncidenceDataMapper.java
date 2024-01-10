package com.gfmartinez.hexagonalarchitecture.domain.application.model.mapper;

import com.gfmartinez.hexagonalarchitecture.domain.application.model.dto.create.CreateIncidenceCommandDto;
import com.gfmartinez.hexagonalarchitecture.domain.application.model.dto.create.CreateIncidenceResponseDto;
import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Incidence;
import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Reporter;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentFileName;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentFormat;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentId;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentSize;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentUri;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.ClientId;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceDescription;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceHeader;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.ReporterId;

//@Component
public class IncidenceDataMapper {
  public Incidence createIncidenceCommandDtoToIncidence(CreateIncidenceCommandDto createIncidenceCommand) {
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
