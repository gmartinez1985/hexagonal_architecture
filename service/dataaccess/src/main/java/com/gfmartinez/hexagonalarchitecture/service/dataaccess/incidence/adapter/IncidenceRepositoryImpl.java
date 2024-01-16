package com.gfmartinez.hexagonalarchitecture.service.dataaccess.incidence.adapter;

import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.entity.Incidence;
import com.gfmartinez.hexagonalarchitecture.repository.IncidenceRepository;
import com.gfmartinez.hexagonalarchitecture.service.dataaccess.incidence.entity.IncidenceEntity;
import com.gfmartinez.hexagonalarchitecture.service.dataaccess.incidence.mapper.IncidenceDataAccessMapper;
import com.gfmartinez.hexagonalarchitecture.service.dataaccess.incidence.repository.IncidenceJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class IncidenceRepositoryImpl implements IncidenceRepository {

  private final IncidenceJpaRepository incidenceJpaRepository;
  private final IncidenceDataAccessMapper incidenceDataAccessMapper;

  public IncidenceRepositoryImpl(IncidenceJpaRepository incidenceJpaRepository,
      IncidenceDataAccessMapper incidenceDataAccessMapper) {
    this.incidenceJpaRepository = incidenceJpaRepository;
    this.incidenceDataAccessMapper = incidenceDataAccessMapper;
  }

  @Override
  public Incidence save(Incidence incidence) {
    IncidenceEntity incidenceEntity = incidenceDataAccessMapper.incidenceToIncidenceEntity(incidence);
    IncidenceEntity response = incidenceJpaRepository.save(incidenceEntity);
    return incidenceDataAccessMapper.incidenceEntityToIncidence(response);
  }
}
