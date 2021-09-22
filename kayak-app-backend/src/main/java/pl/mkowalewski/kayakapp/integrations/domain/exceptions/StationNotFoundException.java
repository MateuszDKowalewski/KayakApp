package pl.mkowalewski.kayakapp.integrations.domain.exceptions;

public class StationNotFoundException extends RuntimeException {

  public StationNotFoundException(String apiId, Long stationId) {
    super("Not found station for api id: " + apiId + " and station id: " + stationId);
  }
}
