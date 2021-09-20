package pl.mkowalewski.kayakapp.stations.domain;

import org.mapstruct.Mapper;
import pl.mkowalewski.kayakapp.stations.domain.dto.StationDto;

@Mapper
interface StationMapper {

  StationEntity toEntity(StationDto dto);

  StationDto toDto(StationEntity entity);

}
