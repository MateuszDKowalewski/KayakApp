package pl.mkowalewski.kayakapp.integrations.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.mkowalewski.kayakapp.integrations.domain.dto.MeasuringDataDto;

@SpringBootTest
class ImgwDataFacadeTest {

  @Autowired
  ImgwDataFacade imgwDataFacade;

  @Test
  void test_loading_application_context_and_properties() {
    // Temporary test checking properties
    assertAll(
        () -> assertEquals("IMGW", imgwDataFacade.getAPI_ID()),
        () -> assertEquals("https://danepubliczne.imgw.pl/api/data/hydro", imgwDataFacade.getAPI_URL())
    );
  }

  @Test
  void imgw_facade_should_return_not_empty_list_of_measuring_data() {
    List<MeasuringDataDto> stationsData = imgwDataFacade.getStationsData();
    assertAll(
        () -> assertNotNull(stationsData),
        () -> assertFalse(stationsData.isEmpty())
    );
  }

}
