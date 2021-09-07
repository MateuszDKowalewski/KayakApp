package pl.mkowalewski.kayakapp.integrations.domain;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.mkowalewski.kayakapp.integrations.domain.dto.MeasuringDataDto;

@Mapper
abstract class MeasuringDataMapper {

  @Mapping(target = "stationId", source = "id_stacji")
  @Mapping(target = "stationName", source = "stacja")
  @Mapping(target = "riverName", source = "rzeka")
  @Mapping(target = "waterLevel", source = "stan_wody")
  @Mapping(target = "waterLevelMeasureTime", source = "stan_wody_data_pomiaru")
  @Mapping(target = "apiId", source = "entity", qualifiedByName = "setApiId")
  public abstract MeasuringDataDto toDto(ImgwDataEntity entity, @Context String apiId);

  @Named("setApiId")
  public static String setApiId(ImgwDataEntity entity, @Context String apiId) {
    return apiId;
  }

}
