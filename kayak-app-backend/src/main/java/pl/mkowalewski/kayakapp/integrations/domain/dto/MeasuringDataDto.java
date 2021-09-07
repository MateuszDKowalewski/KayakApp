package pl.mkowalewski.kayakapp.integrations.domain.dto;

import lombok.Data;

@Data
public class MeasuringDataDto {
  private String apiId;
  private String stationId;
  private String stationName;
  private String riverName;
  private Integer waterLevel;
  private String waterLevelMeasureTime; // LocalDateTime
}
