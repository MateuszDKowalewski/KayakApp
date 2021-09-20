package pl.mkowalewski.kayakapp.stations.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface StationsRepository extends JpaRepository<StationEntity, Long> {

}
