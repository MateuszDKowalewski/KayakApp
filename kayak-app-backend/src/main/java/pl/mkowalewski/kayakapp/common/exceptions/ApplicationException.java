package pl.mkowalewski.kayakapp.common.exceptions;

public abstract class ApplicationException extends RuntimeException {

  private final ErrorType errorType;

  public ApplicationException(String message, ErrorType errorType) {
    super(message);
    this.errorType = errorType;
  }

  public abstract ErrorResponse getResponse();

  public ErrorType getErrorType() {
    return errorType;
  }

}
