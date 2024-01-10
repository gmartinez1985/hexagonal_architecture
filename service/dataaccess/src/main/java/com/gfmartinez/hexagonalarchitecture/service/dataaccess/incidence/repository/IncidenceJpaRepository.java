package com.gfmartinez.hexagonalarchitecture.service.dataaccess.incidence.repository;

import com.gfmartinez.hexagonalarchitecture.service.dataaccess.incidence.entity.IncidenceEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidenceJpaRepository extends JpaRepository<IncidenceEntity, UUID> {

}
