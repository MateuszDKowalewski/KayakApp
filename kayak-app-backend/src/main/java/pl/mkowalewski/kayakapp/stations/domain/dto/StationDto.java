package pl.mkowalewski.kayakapp.stations.domain.dto;

import lombok.Data;

@Data
public class StationDto {
  private Long id;
  private String apiId;
  private Long stationExternalId;
  private String stationName;
  private String riverName;
}
