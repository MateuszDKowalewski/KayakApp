package pl.mkowalewski.kayakapp.stations.domain.exceptions;

import pl.mkowalewski.kayakapp.common.exceptions.NotFoundException;

public class StationNotFoundException extends NotFoundException {

  public StationNotFoundException(Long id) {
    super("Not found station with id: " + id);
  }

}
