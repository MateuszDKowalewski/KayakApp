package pl.mkowalewski.kayakapp.common.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
  String message;
  ErrorType errorType;
}
