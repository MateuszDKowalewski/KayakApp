package pl.mkowalewski.kayakapp.measurs.domain.dto;

import java.time.LocalDateTime;
import lombok.Data;
import pl.mkowalewski.kayakapp.stations.domain.dto.StationDto;

@Data
public class MeasuringDataDto {
  private Long id;
  private Long stationId;
  private StationDto station;
  private Integer waterLevel;
  private LocalDateTime measuringTime;
}
