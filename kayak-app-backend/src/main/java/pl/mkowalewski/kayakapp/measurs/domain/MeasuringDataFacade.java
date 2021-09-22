package pl.mkowalewski.kayakapp.measurs.domain;

import lombok.AllArgsConstructor;
import pl.mkowalewski.kayakapp.measurs.domain.dto.MeasuringDataDto;
import pl.mkowalewski.kayakapp.stations.domain.StationsViewFacade;

@AllArgsConstructor
public class MeasuringDataFacade {

  private final MeasurigDataRepository measurigDataRepository;
  private final MeasuringDataMapper measuringDataMapper;
  private final StationsViewFacade stationsViewFacade;

  public MeasuringDataDto addMeasuringData(MeasuringDataDto dto) {
    // TODO: KD-8 add validator
    MeasuringDataEntity entity = new MeasuringDataEntity();
    entity.setStation(stationsViewFacade.getStation(dto.getStationId()));
    entity.setWaterLevel(dto.getWaterLevel());
    MeasuringDataEntity savedEntity = measurigDataRepository.save(entity);
    return measuringDataMapper.toDto(savedEntity);
  }


}
