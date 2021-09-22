package pl.mkowalewski.kayakapp.measurs;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mkowalewski.kayakapp.measurs.domain.MeasuringDataFacade;
import pl.mkowalewski.kayakapp.measurs.domain.dto.MeasuringDataDto;

@RestController
@RequestMapping("api/measuring-data")
@AllArgsConstructor
class MeasuringDataController {

  private final MeasuringDataFacade measuringDataFacade;

  @GetMapping
  private ResponseEntity<List<MeasuringDataDto>> getAllMeasuringData() {
    return new ResponseEntity<>(measuringDataFacade.getAll(), HttpStatus.OK);
  }

  @PostMapping
  private ResponseEntity<MeasuringDataDto> addMeasuringData(@RequestBody MeasuringDataDto dto) {
    return new ResponseEntity<>(measuringDataFacade.addMeasuringData(dto), HttpStatus.OK);
  }

}
