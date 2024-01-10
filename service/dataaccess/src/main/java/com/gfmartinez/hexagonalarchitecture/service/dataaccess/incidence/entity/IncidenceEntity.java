package com.gfmartinez.hexagonalarchitecture.service.dataaccess.incidence.entity;

import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceSeverity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
// Needed for Spring to create proxies for this class
@NoArgsConstructor
// Needed for the builder pattern
@AllArgsConstructor
@Table(name = "incidences")
@Entity
public class IncidenceEntity {

  @Id
  private UUID id;
  private String header;
  private String description;
  private UUID reporterId;
  private UUID clientId;
  @Enumerated(EnumType.STRING)
  private IncidenceSeverity severity;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IncidenceEntity that = (IncidenceEntity) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
