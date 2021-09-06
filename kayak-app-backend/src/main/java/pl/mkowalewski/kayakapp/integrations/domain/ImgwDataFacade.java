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

  private final ImgwDataMapper imgwDataMapper;
  private final String API_ID;
  private final String API_URL;

  public List<MeasuringDataDto> getStationsData() {
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    HttpEntity<String> httpEntity = new HttpEntity<>("params", headers);
    ResponseEntity<List<ImgwDataEntity>> result = restTemplate.exchange(API_URL, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<ImgwDataEntity>>() {});

    return result.getBody()
        .stream()
        .map(imgwDataMapper::toDto)
        .collect(Collectors.toList());
  }

}
