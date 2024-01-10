package com.gfmartinez.hexagonalarchitecture.service.dataaccess.incidence.mapper;

import com.gfmartinez.hexagonalarchitecture.domain.model.entity.Incidence;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.ClientId;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceDescription;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceHeader;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceSeverity;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.ReporterId;
import com.gfmartinez.hexagonalarchitecture.service.dataaccess.incidence.entity.IncidenceEntity;
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
