package pl.mkowalewski.kayakapp.measurs.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface MeasurigDataRepository extends JpaRepository<MeasuringDataEntity, Long> {

}
