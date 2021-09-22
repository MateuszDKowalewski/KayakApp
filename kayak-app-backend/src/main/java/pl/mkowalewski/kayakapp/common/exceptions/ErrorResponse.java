package pl.mkowalewski.kayakapp.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
  String message;
  ErrorType errorType;
}
