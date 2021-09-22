package pl.mkowalewski.kayakapp.measurs.domain;

import lombok.AllArgsConstructor;
import pl.mkowalewski.kayakapp.measurs.domain.dto.MeasuringDataDto;
import pl.mkowalewski.kayakapp.stations.domain.StationsViewFacade;

@AllArgsConstructor
class MeasuringDataFacade {

  private final MeasurigDataRepository measurigDataRepository;
  private final MeasuringDataMapper measuringDataMapper;
  private final StationsViewFacade stationsFacade;

  public MeasuringDataDto addMeasuringData(MeasuringDataDto dto) {
    return null;
  }


}
