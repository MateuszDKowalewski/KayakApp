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

@AllArgsConstructor
public class ImgwDataFacade {

  private final MeasuringDataMapper measuringDataMapper;
  private final String API_ID;
  private final String API_URL;

  public List<MeasuringDataDto> getStationsData() {
    System.out.println("Dupa");
    System.out.println(API_ID);
    System.out.println(API_URL);
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> httpEntity = new HttpEntity<>("params", headers);
    ParameterizedTypeReference<List<ImgwDataEntity>> responseType = new ParameterizedTypeReference<List<ImgwDataEntity>>() {};
    ResponseEntity<List<ImgwDataEntity>> result = restTemplate.exchange(API_URL, HttpMethod.GET, httpEntity, responseType);
    System.out.println("Dupa");
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
        .orElseThrow(() -> new Exception("Not found station for apiId: " + API_ID + " and id: " + stationId));
  }

}
