package pl.mkowalewski.kayakapp.integrations;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mkowalewski.kayakapp.integrations.domain.ImgwDataFacade;
import pl.mkowalewski.kayakapp.integrations.domain.dto.MeasuringDataDto;

@RestController
@RequestMapping("api/integrations")
@AllArgsConstructor
class IntegrationsController {

  private final ImgwDataFacade imgwDataFacade;

  @GetMapping(path = "imgw")
  private ResponseEntity<List<MeasuringDataDto>> getStationsData() {
    return new ResponseEntity<>(imgwDataFacade.getStationsData(), HttpStatus.OK);
  }

  @GetMapping(path = "imgw/{stationId}")
  private ResponseEntity<MeasuringDataDto> getStationData(@PathVariable Long stationId) {
    return new ResponseEntity<>(imgwDataFacade.getStationData(stationId), HttpStatus.OK);
  }

}
