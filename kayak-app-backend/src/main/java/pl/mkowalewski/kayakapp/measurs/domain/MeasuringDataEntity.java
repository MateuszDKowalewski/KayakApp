package pl.mkowalewski.kayakapp.measurs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;
import pl.mkowalewski.kayakapp.stations.domain.StationViewEntity;

@Entity
@Table(name = "measuring_data")
@Data
class MeasuringDataEntity {

  @Id
  @SequenceGenerator(name = "measuring_data_s", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "measuring_data_s")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "station_id")
  private StationViewEntity station;

  private Integer waterLevel;

}
