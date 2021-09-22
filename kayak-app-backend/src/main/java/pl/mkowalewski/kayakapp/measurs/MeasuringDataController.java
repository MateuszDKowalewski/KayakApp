package pl.mkowalewski.kayakapp.measurs;

import java.util.List;
import lombok.AllArgsConstructor;
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
  private List<MeasuringDataDto> getAllMeasuringData() {
    return measuringDataFacade.getAll();
  }

  @PostMapping
  private MeasuringDataDto addMeasuringData(@RequestBody MeasuringDataDto dto) {
    return measuringDataFacade.addMeasuringData(dto);
  }

}
