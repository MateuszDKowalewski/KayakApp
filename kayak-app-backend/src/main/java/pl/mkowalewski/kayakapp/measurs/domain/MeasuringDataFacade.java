package pl.mkowalewski.kayakapp.measurs.domain;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import pl.mkowalewski.kayakapp.measurs.domain.dto.MeasuringDataDto;
import pl.mkowalewski.kayakapp.stations.domain.StationsViewFacade;

@AllArgsConstructor
public class MeasuringDataFacade {

  private final MeasurigDataRepository measurigDataRepository;
  private final MeasuringDataMapper measuringDataMapper;
  private final StationsViewFacade stationsViewFacade;

  public List<MeasuringDataDto> getAll() {
    return measurigDataRepository.findAll()
        .stream()
        .map(measuringDataMapper::toDto)
        .collect(Collectors.toList());
  }

  public MeasuringDataDto addMeasuringData(MeasuringDataDto dto) {
    // TODO: KD-8 add validator
    MeasuringDataEntity entity = new MeasuringDataEntity();
    entity.setStation(stationsViewFacade.getStation(dto.getStationId()));
    entity.setMeasuringTime(dto.getMeasuringTime());
    entity.setWaterLevel(dto.getWaterLevel());
    MeasuringDataEntity savedEntity = measurigDataRepository.save(entity);
    return measuringDataMapper.toDto(savedEntity);
  }
}
