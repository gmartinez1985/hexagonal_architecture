package com.gfmartinez.hexagonalarchitecture.model.mapper;

import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.entity.Incidence;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.ClientId;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.IncidenceDescription;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.IncidenceHeader;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.ReporterId;
import com.gfmartinez.hexagonalarchitecture.model.dto.CreateIncidenceCommandDto;
import com.gfmartinez.hexagonalarchitecture.model.dto.CreateIncidenceResponseDto;

//@Component
public class IncidenceDataMapperFactory {
  public Incidence createIncidenceCommandDtoToIncidence(
      CreateIncidenceCommandDto createIncidenceCommand) {
    // TODO: To create a builder pattern in Incidence and use it here.
    return Incidence.newIncidence(
        new IncidenceHeader(createIncidenceCommand.getHeader()),
        new IncidenceDescription(createIncidenceCommand.getDescription()),
        new ClientId(createIncidenceCommand.getClientId()),
        createIncidenceCommand.getSeverity(),
        new ReporterId(createIncidenceCommand.getReporterId()));
  }

//  public Incidence createIncidenceWithAttachmentCommandDtoToIncidence(
//      CreateIncidenceCommandDto createIncidenceCommand) {
//    // TODO: To create a builder pattern in Incidence and use it here.
//    return Incidence.newIncidenceWithAttachment(
//        new IncidenceHeader(createIncidenceCommand.getHeader()),
//        new IncidenceDescription(createIncidenceCommand.getDescription()),
//        new ClientId(createIncidenceCommand.getClientId()),
//        createIncidenceCommand.getSeverity(),
//        new ReporterId(createIncidenceCommand.getReporterId()),
//        new AttachmentId(1L),
//        new AttachmentFileName(createIncidenceCommand.getAttachment().getFileName()),
//        new AttachmentFormat(createIncidenceCommand.getAttachment().getFormat()),
//        new AttachmentSize(createIncidenceCommand.getAttachment().getSize()),
//        new AttachmentUri(createIncidenceCommand.getAttachment().getUri()));
//  }

  public CreateIncidenceResponseDto incidenceToCreateIncidenceResponseDto(Incidence incidence) {
    return CreateIncidenceResponseDto.builder()
        .incidenceId(incidence.getId().getValue())
        .header(incidence.getHeader().getValue())
        .description(incidence.getDescription().getValue())
        .build();
  }

}
