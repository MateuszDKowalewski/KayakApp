package pl.mkowalewski.kayakapp.measurs.domain;

import org.mapstruct.Mapper;
import pl.mkowalewski.kayakapp.measurs.domain.dto.MeasuringDataDto;
import pl.mkowalewski.kayakapp.stations.domain.StationViewMapper;

@Mapper(uses = StationViewMapper.class)
interface MeasuringDataMapper {

  MeasuringDataDto toDto(MeasuringDataEntity entity);

}
