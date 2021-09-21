package pl.mkowalewski.kayakapp.stations.domain;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import pl.mkowalewski.kayakapp.stations.domain.dto.StationDto;

@AllArgsConstructor
public class StationsFacade {

  private final StationsRepository stationsRepository;
  private final StationMapper stationMapper;

  public List<StationDto> getAllStations() {
    return stationsRepository.findAll()
        .stream()
        .map(stationMapper::toDto)
        .collect(Collectors.toList());
  }

  public StationDto findStation(Long id) {
    return stationMapper.toDto(stationsRepository.getById(id));
  }

  public StationDto addStation(StationDto dto) {
    // TODO: KA-8 add validator
    StationEntity entity = stationMapper.toEntity(dto);
    StationEntity savedEntity = stationsRepository.save(entity);
    return stationMapper.toDto(savedEntity);
  }
}
