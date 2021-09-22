package pl.mkowalewski.kayakapp.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class ExceptionsHandler {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  ErrorResponse notFoundExceptionHandler(NotFoundException e) {
    return e.getResponse();
  }

  @ExceptionHandler(ValidationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  ErrorResponse validationExceptionHandler(ValidationException e) {
    return e.getResponse();
  }

}
