package ru.danchenski.SensorDataHandler.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.danchenski.SensorDataHandler.entities.MeasurementEntity;
import ru.danchenski.SensorDataHandler.entities.SensorEntity;
import ru.danchenski.SensorDataHandler.models.MeasurementDTO;
import ru.danchenski.SensorDataHandler.models.SensorDTO;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MeasurementMapper {
    List<MeasurementDTO> toMeasurementsDTOs(List<MeasurementEntity> measurementEntities);

    MeasurementEntity toMeasurementEntity(MeasurementDTO measurementDTO);

    MeasurementDTO toMeasurementDTO(MeasurementEntity measurementEntity );
}
