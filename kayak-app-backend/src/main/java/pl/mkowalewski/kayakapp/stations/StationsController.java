package pl.mkowalewski.kayakapp.stations;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mkowalewski.kayakapp.stations.domain.StationsFacade;
import pl.mkowalewski.kayakapp.stations.domain.dto.StationDto;

@RestController
@RequestMapping("api/stations")
@AllArgsConstructor
class StationsController {

  private final StationsFacade stationsFacade;

  @GetMapping()
  private ResponseEntity<List<StationDto>> getAllStations() {
    return new ResponseEntity<>(stationsFacade.getAllStations(), HttpStatus.OK);
  }

  @GetMapping("{id}")
  private ResponseEntity<StationDto> getStationById(@PathVariable Long id) {
    return new ResponseEntity<>(stationsFacade.findStation(id), HttpStatus.OK);
  }

  @PostMapping
  private ResponseEntity<StationDto> addStation(@RequestBody StationDto dto) {
    return new ResponseEntity<>(stationsFacade.addStation(dto), HttpStatus.OK);
  }

}
