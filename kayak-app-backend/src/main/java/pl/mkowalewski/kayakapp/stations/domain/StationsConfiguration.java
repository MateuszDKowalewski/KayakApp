package pl.mkowalewski.kayakapp.stations.domain;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class StationsConfiguration {

  @Bean
  StationsFacade stationsFacade(StationsRepository stationsRepository) {
    StationMapper stationMapper = Mappers.getMapper(StationMapper.class);
    return new StationsFacade(stationsRepository, stationMapper);
  }

  @Bean
  StationsViewFacade stationsViewFacade(StationsViewRepository stationsViewRepository) {
    return new StationsViewFacade(stationsViewRepository);
  }

}
