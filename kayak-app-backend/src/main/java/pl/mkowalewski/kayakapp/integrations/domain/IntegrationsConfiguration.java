package pl.mkowalewski.kayakapp.integrations.domain;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class IntegrationsConfiguration {

  @Value("${imgw.api.id}")
  private String IMGW_API_ID;

  @Value("${imgw.api.url}")
  private String IMGW_API_URL;

  @Bean
  public ImgwDataFacade imgwDataFacade() {
    ImgwDataMapper imgwDataMapper = Mappers.getMapper(ImgwDataMapper.class);
    return new ImgwDataFacade(imgwDataMapper, IMGW_API_ID, IMGW_API_URL);
  }

}
