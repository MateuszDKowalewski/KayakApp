package pl.mkowalewski.kayakapp.stations.domain;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import pl.mkowalewski.kayakapp.stations.domain.dto.StationDto;
import pl.mkowalewski.kayakapp.stations.domain.exceptions.StationNotFoundException;

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
    StationEntity stationEntity = stationsRepository.findById(id)
        .orElseThrow(() -> new StationNotFoundException(id));
    return stationMapper.toDto(stationEntity);
  }

  public StationDto addStation(StationDto dto) {
    StationDtoValidator.validateForInstert(dto);
    StationEntity entity = stationMapper.toEntity(dto);
    StationEntity savedEntity = stationsRepository.save(entity);
    return stationMapper.toDto(savedEntity);
  }
}
