package com.gfmartinez.hexagonalarchitecture.domain.model.entity;

import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.UserEmail;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.UserLastName;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.UserName;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.UserUsername;

public class Reporter extends User{

  public Reporter(UserName name,
      UserLastName lastName,
      UserUsername username,
      UserEmail email,
      Boolean isActive) {
    super(name, lastName, username, email, isActive);
  }
}
