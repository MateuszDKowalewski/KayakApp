package pl.mkowalewski.kayakapp.integrations.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.mkowalewski.kayakapp.common.exceptions.ErrorResponse;
import pl.mkowalewski.kayakapp.common.exceptions.ErrorType;

@RestControllerAdvice
class ExceptionsHandler {

  @ExceptionHandler(StationNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  ErrorResponse stationNotFoundHandler(StationNotFoundException e) {
    return new ErrorResponse(e.getMessage(), ErrorType.NOT_FOUND);
  }


}
