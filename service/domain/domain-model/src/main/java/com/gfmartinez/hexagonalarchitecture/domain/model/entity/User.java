package com.gfmartinez.hexagonalarchitecture.domain.model.entity;

import com.gfmartinez.hexagonalarchitecture.domain.entity.AggregateRoot;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.UserEmail;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.UserId;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.UserLastName;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.UserName;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.UserUsername;
import java.util.UUID;

public abstract class User extends AggregateRoot<UserId> {
  protected UserName name;
  protected UserLastName lastName;
  protected UserUsername username;

  protected UserEmail email;
  protected Boolean isActive;

  public User(UserName name, UserLastName lastName, UserUsername username, UserEmail email,
      Boolean isActive) {
    super.id = new UserId(UUID.randomUUID());
    this.name = name;
    this.lastName = lastName;
    this.username = username;
    this.email = email;
    this.isActive = isActive;
  }
}
