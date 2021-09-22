package pl.mkowalewski.kayakapp.stations;

import java.util.List;
import lombok.AllArgsConstructor;
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
  private List<StationDto> getAllStations() {
    return stationsFacade.getAllStations();
  }

  @GetMapping("{id}")
  private StationDto getStationById(@PathVariable Long id) {
    return stationsFacade.findStation(id);
  }

  @PostMapping
  private StationDto addStation(@RequestBody StationDto dto) {
    return stationsFacade.addStation(dto);
  }

}
