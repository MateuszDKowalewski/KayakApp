package pl.mkowalewski.kayakapp.measurs.domain;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.mkowalewski.kayakapp.stations.domain.StationsViewFacade;

@Configuration
class MeasuringDataConfiguration {

  @Bean
  MeasuringDataFacade measuringDataFacade(
      MeasurigDataRepository measurigDataRepository,
      StationsViewFacade stationsViewFacade
  ) {
    MeasuringDataMapper measuringDataMapper = Mappers.getMapper(MeasuringDataMapper.class);
    return new MeasuringDataFacade(
      measurigDataRepository,
      measuringDataMapper,
      stationsViewFacade
    );
  }

}
