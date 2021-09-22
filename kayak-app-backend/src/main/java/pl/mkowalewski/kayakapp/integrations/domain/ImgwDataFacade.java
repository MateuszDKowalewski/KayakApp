package pl.mkowalewski.kayakapp.integrations.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.mkowalewski.kayakapp.integrations.domain.dto.MeasuringDataDto;
import pl.mkowalewski.kayakapp.integrations.domain.exceptions.StationNotFoundException;

@AllArgsConstructor
public class ImgwDataFacade {

  private final MeasuringDataMapper measuringDataMapper;
  private final String API_ID;
  private final String API_URL;

  public List<MeasuringDataDto> getStationsData() {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> httpEntity = new HttpEntity<>("params", headers);
    ParameterizedTypeReference<List<ImgwDataEntity>> responseType = new ParameterizedTypeReference<List<ImgwDataEntity>>() {};
    ResponseEntity<List<ImgwDataEntity>> result = restTemplate.exchange(API_URL, HttpMethod.GET, httpEntity, responseType);
    return result.getBody()
        .stream()
        .map(data -> measuringDataMapper.toDto(data, API_ID))
        .collect(Collectors.toList());
  }

  public MeasuringDataDto getStationData(Long stationId) throws Exception {
    // TODO: KA-8 handle exception
    return getStationsData()
        .stream()
        .filter(stationData -> stationData.getStationId().equals(stationId))
        .findFirst()
        .orElseThrow(() -> new StationNotFoundException(API_ID, stationId));
  }

  public String getAPI_ID() {
    // Temporary getter for test
    return API_ID;
  }

  public String getAPI_URL() {
    // Temporary getter for test
    return API_URL;
  }
}
