package ru.danchenski.SensorDataHandler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danchenski.SensorDataHandler.entities.MeasurementEntity;

@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementEntity, Integer> {
}
