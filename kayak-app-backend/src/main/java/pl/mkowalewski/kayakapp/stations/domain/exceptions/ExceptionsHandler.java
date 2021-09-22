package pl.mkowalewski.kayakapp.stations.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.mkowalewski.kayakapp.common.exceptions.ErrorResponse;
import pl.mkowalewski.kayakapp.common.exceptions.ErrorType;

@ControllerAdvice
public class ExceptionsHandler {

  @ResponseBody
  @ExceptionHandler(StationNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse stationNotFoundHandler(StationNotFoundException e) {
    return new ErrorResponse(e.getMessage(), ErrorType.NOT_FOUND);
  }

}
