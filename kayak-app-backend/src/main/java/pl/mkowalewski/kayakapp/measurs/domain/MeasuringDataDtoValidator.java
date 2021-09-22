package pl.mkowalewski.kayakapp.measurs.domain;

import java.util.HashMap;
import java.util.Map;
import pl.mkowalewski.kayakapp.common.exceptions.ValidationErrorType;
import pl.mkowalewski.kayakapp.measurs.domain.dto.MeasuringDataDto;
import pl.mkowalewski.kayakapp.stations.domain.exceptions.StationValidationException;

class MeasuringDataDtoValidator {

  private MeasuringDataDtoValidator() throws Exception {
    throw new Exception("Can't instantiate static validator class");
  }

  static void validateForInsert(MeasuringDataDto dto) {
    Map<String, ValidationErrorType> validationError = new HashMap<>();
    if(dto.getId() != null) {
      validationError.put("id", ValidationErrorType.NOT_NULL);
    }
    if(dto.getStationId() == null) {
      validationError.put("stationId", ValidationErrorType.NULL);
    }
    if(dto.getWaterLevel() == null) {
      validationError.put("waterLevel", ValidationErrorType.NULL);
    }
    if(dto.getMeasuringTime() == null) {
      validationError.put("measuringTime", ValidationErrorType.NULL);
    }
    if(!validationError.isEmpty()) {
      throw new StationValidationException("Invalid measuring data dto for insert", validationError);
    }
  }

}
