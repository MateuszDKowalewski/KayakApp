package pl.mkowalewski.kayakapp.common.exceptions;

import pl.mkowalewski.kayakapp.common.exceptions.ErrorResponse.ErrorResponseBuilder;

public abstract class NotFoundException extends ApplicationException {

  public NotFoundException(String message) {
    super(message, ErrorType.NOT_FOUND_EXCEPTION);
  }

  @Override
  public ErrorResponse getResponse() {
    return new ErrorResponseBuilder()
        .errorType(this.getErrorType())
        .message(this.getMessage())
        .build();
  }
}
