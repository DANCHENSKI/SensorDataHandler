package ru.danchenski.SensorDataHandler.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.danchenski.SensorDataHandler.entities.MeasurementEntity;
import ru.danchenski.SensorDataHandler.entities.SensorEntity;
import ru.danchenski.SensorDataHandler.models.MeasurementDTO;
import ru.danchenski.SensorDataHandler.models.SensorDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-21T23:36:52+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.1.jar, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class MeasurementMapperImpl implements MeasurementMapper {

    @Override
    public List<MeasurementDTO> toMeasurementsDTOs(List<MeasurementEntity> measurementEntities) {
        if ( measurementEntities == null ) {
            return null;
        }

        List<MeasurementDTO> list = new ArrayList<MeasurementDTO>( measurementEntities.size() );
        for ( MeasurementEntity measurementEntity : measurementEntities ) {
            list.add( toMeasurementDTO( measurementEntity ) );
        }

        return list;
    }

    @Override
    public MeasurementEntity toMeasurementEntity(MeasurementDTO measurementDTO) {
        if ( measurementDTO == null ) {
            return null;
        }

        MeasurementEntity measurementEntity = new MeasurementEntity();

        measurementEntity.setValue( measurementDTO.getValue() );
        measurementEntity.setRaining( measurementDTO.getRaining() );
        measurementEntity.setSensor( sensorDTOToSensorEntity( measurementDTO.getSensor() ) );

        return measurementEntity;
    }

    @Override
    public MeasurementDTO toMeasurementDTO(MeasurementEntity measurementEntity) {
        if ( measurementEntity == null ) {
            return null;
        }

        MeasurementDTO measurementDTO = new MeasurementDTO();

        measurementDTO.setValue( measurementEntity.getValue() );
        measurementDTO.setRaining( measurementEntity.getRaining() );
        measurementDTO.setSensor( sensorEntityToSensorDTO( measurementEntity.getSensor() ) );

        return measurementDTO;
    }

    protected SensorEntity sensorDTOToSensorEntity(SensorDTO sensorDTO) {
        if ( sensorDTO == null ) {
            return null;
        }

        SensorEntity sensorEntity = new SensorEntity();

        sensorEntity.setName( sensorDTO.getName() );

        return sensorEntity;
    }

    protected SensorDTO sensorEntityToSensorDTO(SensorEntity sensorEntity) {
        if ( sensorEntity == null ) {
            return null;
        }

        SensorDTO sensorDTO = new SensorDTO();

        sensorDTO.setName( sensorEntity.getName() );

        return sensorDTO;
    }
}
