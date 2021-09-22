package pl.mkowalewski.kayakapp.stations.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface StationsViewRepository extends JpaRepository<StationViewEntity, Long> {

}
