package pl.mkowalewski.kayakapp.stations.domain;

import lombok.AllArgsConstructor;
import pl.mkowalewski.kayakapp.stations.domain.dto.StationDto;

@AllArgsConstructor
public class StationsFacade {

  private final StationsRepository stationsRepository;
  private final StationMapper stationMapper;

  public StationDto addStation(StationDto dto) {
    // TODO: KA-8 add validator
    StationEntity entity = stationMapper.toEntity(dto);
    StationEntity savedEntity = stationsRepository.save(entity);
    return stationMapper.toDto(savedEntity);
  }

}
