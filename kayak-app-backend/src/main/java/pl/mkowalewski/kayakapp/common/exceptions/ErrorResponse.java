package pl.mkowalewski.kayakapp.common.exceptions;

import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
  private String message;
  private ErrorType errorType;
  private Map<String, ValidationErrorType> validationError;
}
