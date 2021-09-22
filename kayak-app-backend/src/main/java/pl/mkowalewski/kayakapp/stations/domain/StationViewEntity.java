package pl.mkowalewski.kayakapp.stations.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "measuring_stations")
@Getter
public class StationViewEntity {

  @Id
  @SequenceGenerator(name = "measuring_stations_s", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "measuring_stations_s")
  private Long id;

  private String apiId;

  private Long stationExternalId;

  private String stationName;

  private String riverName;

}
