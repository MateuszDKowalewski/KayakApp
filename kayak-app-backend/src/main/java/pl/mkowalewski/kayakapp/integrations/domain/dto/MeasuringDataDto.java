package pl.mkowalewski.kayakapp.integrations.domain.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MeasuringDataDto {
  private String apiId;
  private Long stationId;
  private String stationName;
  private String riverName;
  private Integer waterLevel;
  private LocalDateTime waterLevelMeasureTime;
}
