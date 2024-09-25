package ru.danchenski.SensorDataHandler.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.danchenski.SensorDataHandler.entities.SensorEntity;
import ru.danchenski.SensorDataHandler.models.SensorDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-21T17:02:53+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.1.jar, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class SensorMapperImpl implements SensorMapper {

    @Override
    public List<SensorDTO> toSensorDTOs(List<SensorEntity> sensorEntities) {
        if ( sensorEntities == null ) {
            return null;
        }

        List<SensorDTO> list = new ArrayList<SensorDTO>( sensorEntities.size() );
        for ( SensorEntity sensorEntity : sensorEntities ) {
            list.add( toSensorDTO( sensorEntity ) );
        }

        return list;
    }

    @Override
    public SensorEntity toSensorEntity(SensorDTO sensorDTO) {
        if ( sensorDTO == null ) {
            return null;
        }

        SensorEntity sensorEntity = new SensorEntity();

        sensorEntity.setName( sensorDTO.getName() );

        return sensorEntity;
    }

    @Override
    public SensorDTO toSensorDTO(SensorEntity sensorEntity) {
        if ( sensorEntity == null ) {
            return null;
        }

        SensorDTO sensorDTO = new SensorDTO();

        sensorDTO.setName( sensorEntity.getName() );

        return sensorDTO;
    }
}
