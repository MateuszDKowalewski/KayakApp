package pl.mkowalewski.kayakapp.integrations.domain.exceptions;

import pl.mkowalewski.kayakapp.common.exceptions.NotFoundException;

public class StationNotFoundException extends NotFoundException {

  public StationNotFoundException(String apiId, Long stationId) {
    super("Not found station for api id: " + apiId + " and station id: " + stationId);
  }

}
