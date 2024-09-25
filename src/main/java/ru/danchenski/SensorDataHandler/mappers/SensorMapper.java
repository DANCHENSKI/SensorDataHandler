package ru.danchenski.SensorDataHandler.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.danchenski.SensorDataHandler.entities.SensorEntity;
import ru.danchenski.SensorDataHandler.models.SensorDTO;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SensorMapper {
    List<SensorDTO> toSensorDTOs(List<SensorEntity> sensorEntities);

    SensorEntity toSensorEntity(SensorDTO sensorDTO);

    SensorDTO toSensorDTO(SensorEntity sensorEntity);
}
