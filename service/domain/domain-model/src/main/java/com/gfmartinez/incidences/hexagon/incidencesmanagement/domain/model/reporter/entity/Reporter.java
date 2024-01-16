package com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.reporter.entity;

import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.user.entity.User;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.user.valueobject.UserEmail;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.user.valueobject.UserLastName;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.user.valueobject.UserName;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.user.valueobject.UserUsername;

public class Reporter extends User {

  public Reporter(UserName name,
      UserLastName lastName,
      UserUsername username,
      UserEmail email,
      Boolean isActive) {
    super(name, lastName, username, email, isActive);
  }
}
