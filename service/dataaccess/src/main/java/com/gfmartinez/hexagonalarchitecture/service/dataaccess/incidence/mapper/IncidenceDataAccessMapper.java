package com.gfmartinez.hexagonalarchitecture.service.dataaccess.incidence.mapper;

import com.gfmartinez.hexagonalarchitecture.service.dataaccess.incidence.entity.IncidenceEntity;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.entity.Incidence;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.ClientId;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.IncidenceDescription;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.IncidenceHeader;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.ReporterId;
import org.springframework.stereotype.Component;

@Component
public class IncidenceDataAccessMapper {
  //TODO: Por el principio de Demeter, hacer que Incidence devuelva los tipos de datos básicos y no los VO
  public IncidenceEntity incidenceToIncidenceEntity(Incidence incidence) {
    return IncidenceEntity.builder()
        .id(incidence.getId().getValue())
        .header(incidence.getHeader().getValue())
        .description(incidence.getDescription().getValue())
        .reporterId(incidence.getReportedId())
        .clientId(incidence.getClientId())
        .severity(incidence.getSeverity())
        .build();
  }

  public Incidence incidenceEntityToIncidence(IncidenceEntity incidenceEntity) {
    //TODO: Este constructor debería recibir tipos básicos, de manera que los detalles de los tipos de VO queden encapsulados dentro del constructor
    return Incidence.newIncidence(
        new IncidenceHeader(incidenceEntity.getHeader()),
        new IncidenceDescription(incidenceEntity.getDescription()),
        new ClientId(incidenceEntity.getClientId()),
        incidenceEntity.getSeverity(),
        new ReporterId(incidenceEntity.getReporterId())
    );
  }
}
