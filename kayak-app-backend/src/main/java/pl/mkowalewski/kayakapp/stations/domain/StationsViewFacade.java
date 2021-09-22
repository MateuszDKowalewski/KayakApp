package pl.mkowalewski.kayakapp.stations.domain;

import lombok.AllArgsConstructor;
import pl.mkowalewski.kayakapp.stations.domain.exceptions.StationNotFoundException;

@AllArgsConstructor
public class StationsViewFacade {

  private final StationsViewRepository stationsViewRepository;

  public StationViewEntity getStation(Long id) {
    return stationsViewRepository.findById(id)
        .orElseThrow(() -> new StationNotFoundException(id));
  }

}
