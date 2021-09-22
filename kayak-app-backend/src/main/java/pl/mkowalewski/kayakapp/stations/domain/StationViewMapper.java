package pl.mkowalewski.kayakapp.stations.domain;

import org.mapstruct.Mapper;
import pl.mkowalewski.kayakapp.stations.domain.dto.StationDto;

@Mapper
public interface StationViewMapper {

  StationDto toDto(StationViewEntity viewEntity);

}
