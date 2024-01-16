package com.gfmartinez.hexagonalarchitecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.gfmartinez.hexagonalarchitecture.service.dataaccess.incidence.repository")
@EntityScan(basePackages = "com.gfmartinez.hexagonalarchitecture.service.dataaccess.incidence.entity")
@SpringBootApplication(scanBasePackages = {"com.gfmartinez.hexagonalarchitecture", "com.gfmartinez.incidences.hexagon.incidencesmanagement"})
public class IncidenceServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(IncidenceServiceApplication.class, args);
  }

}
