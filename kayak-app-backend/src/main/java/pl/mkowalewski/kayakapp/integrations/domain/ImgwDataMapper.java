package pl.mkowalewski.kayakapp.integrations.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.mkowalewski.kayakapp.integrations.domain.dto.MeasuringDataDto;

@Mapper
abstract class ImgwDataMapper {

  // TODO: add api id to mapper
  @Mapping(target = "stationId", source = "id_stacji")
  @Mapping(target = "stationName", source = "stacja")
  @Mapping(target = "riverName", source = "rzeka")
  @Mapping(target = "waterLevel", source = "stan_wody")
  @Mapping(target = "waterLevelMeasureTime", source = "stan_wody_data_pomiaru")
  public abstract MeasuringDataDto toDto(ImgwDataEntity entity);

}
