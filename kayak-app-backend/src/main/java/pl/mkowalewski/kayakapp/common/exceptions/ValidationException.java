package pl.mkowalewski.kayakapp.common.exceptions;

public abstract class ValidationException extends ApplicationException {

  public ValidationException(String message) {
    super(message, ErrorType.VALIDATION_EXCEPTION);
  }

  @Override
  public ErrorResponse getResponse() {
    return null;
  }

}
