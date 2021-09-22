package pl.mkowalewski.kayakapp.stations.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StationsViewFacade {

  private final StationsViewRepository stationsViewRepository;

  public StationViewEntity getStation(Long id) {
    return stationsViewRepository.getById(id);
  }

}
