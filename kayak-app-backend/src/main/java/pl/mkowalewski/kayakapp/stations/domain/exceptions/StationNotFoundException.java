package pl.mkowalewski.kayakapp.stations.domain.exceptions;

public class StationNotFoundException extends RuntimeException {

  public StationNotFoundException(Long id) {
    super("Not found station with id: " + id);
  }

}
