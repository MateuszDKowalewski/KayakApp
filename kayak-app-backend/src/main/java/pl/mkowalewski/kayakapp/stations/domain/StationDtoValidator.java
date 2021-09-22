package pl.mkowalewski.kayakapp.stations.domain;

import java.util.HashMap;
import java.util.Map;
import pl.mkowalewski.kayakapp.common.exceptions.ValidationErrorType;
import pl.mkowalewski.kayakapp.stations.domain.dto.StationDto;
import pl.mkowalewski.kayakapp.stations.domain.exceptions.StationValidationException;

class StationDtoValidator {

  private StationDtoValidator() throws Exception {
    throw new Exception("Can't instantiate static validator class");
  }

  static void validateForInstert(StationDto dto) {
    Map<String, ValidationErrorType> validationError = new HashMap<>();
    if(dto.getId() != null) {
      validationError.put("id", ValidationErrorType.NOT_NULL);
    }
    if(dto.getApiId() == null) {
      validationError.put("apiId", ValidationErrorType.NULL);
    }
    if(dto.getStationExternalId() == null) {
      validationError.put("stationExternalId", ValidationErrorType.NULL);
    }
    if(dto.getStationName() == null) {
      validationError.put("stationName", ValidationErrorType.NULL);
    }
    if(dto.getRiverName() == null) {
      validationError.put("riverName", ValidationErrorType.NULL);
    }
    if(!validationError.isEmpty()) {
      throw new StationValidationException("Invalid station dto for insert", validationError);
    }
  }

}
