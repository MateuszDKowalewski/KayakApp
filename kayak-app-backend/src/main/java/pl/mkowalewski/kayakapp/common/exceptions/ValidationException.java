package pl.mkowalewski.kayakapp.common.exceptions;

import java.util.Map;
import pl.mkowalewski.kayakapp.common.exceptions.ErrorResponse.ErrorResponseBuilder;

public abstract class ValidationException extends ApplicationException {

  private final Map<String, ValidationErrorType> validationError;

  public ValidationException(String message, Map<String, ValidationErrorType> validationError) {
    super(message, ErrorType.VALIDATION_EXCEPTION);
    this.validationError = validationError;
  }

  @Override
  public ErrorResponse getResponse() {
    return new ErrorResponseBuilder()
        .errorType(this.getErrorType())
        .message(this.getMessage())
        .validationError(this.validationError)
        .build();
  }

}
