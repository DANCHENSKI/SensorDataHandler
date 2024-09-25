package ru.danchenski.SensorDataHandler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danchenski.SensorDataHandler.entities.SensorEntity;

import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<SensorEntity, String> {
    Optional<SensorEntity> findByName(String name);
}
