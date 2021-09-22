package pl.mkowalewski.kayakapp.stations.domain.exceptions;

import java.util.Map;
import pl.mkowalewski.kayakapp.common.exceptions.ValidationErrorType;
import pl.mkowalewski.kayakapp.common.exceptions.ValidationException;

public class StationValidationException extends ValidationException {

  public StationValidationException(String message, Map<String, ValidationErrorType> validationError) {
    super(message, validationError);
  }

}
