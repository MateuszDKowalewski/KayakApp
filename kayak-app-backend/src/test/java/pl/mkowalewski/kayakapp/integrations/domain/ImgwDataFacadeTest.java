package pl.mkowalewski.kayakapp.integrations.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.mkowalewski.kayakapp.integrations.domain.dto.MeasuringDataDto;

class ImgwDataFacadeTest {

  @Test
  void imgw_facade_should_return_not_empty_list_of_measuring_data() {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImgwDataFacadeConfiguration.class);
    ImgwDataFacade imgwDataFacade = applicationContext.getBean(ImgwDataFacade.class);
    List<MeasuringDataDto> stationsData = imgwDataFacade.getStationsData();
    System.out.println(stationsData.size());
    return;

  }

}

//@Import(CoreConfig.class)
//@Configuration(proxyBeanMethods = false)
//@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "file:application.properties")
@Configuration
//@EnableAutoConfiguration
class ImgwDataFacadeConfiguration {

  @Value("${imgw.api.id}")
  private String IMGW_API_ID;

  @Value("${imgw.api.url}")
  private String IMGW_API_URL;

  @Bean
  ImgwDataFacade imgwDataFacade() {
    MeasuringDataMapper measuringDataMapper = Mappers.getMapper(MeasuringDataMapper.class);
    return new ImgwDataFacade(measuringDataMapper, IMGW_API_ID, IMGW_API_URL);
  }

}