package com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.user.valueobject;

import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.exception.IncidenceDomainException;
import com.gfmartinez.hexagonalarchitecture.domain.valueobject.BaseString;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserEmail extends BaseString {
  private static final String EMAIL_REGEX = "^(.+)@(.+)$";
  private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

  public UserEmail(String value) {
    super(value);
    validate(value);
  }

  private void validate(String email) {
    Matcher matcher = pattern.matcher(email);
    if (!matcher.matches()) {
      throw new IncidenceDomainException("Email address not valid: " + email);
    }
  }
}
