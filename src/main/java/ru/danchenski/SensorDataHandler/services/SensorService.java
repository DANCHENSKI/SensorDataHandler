package ru.danchenski.SensorDataHandler.services;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.danchenski.SensorDataHandler.entities.SensorEntity;
import ru.danchenski.SensorDataHandler.exceptions.MeasurementException;
import ru.danchenski.SensorDataHandler.mappers.SensorMapper;
import ru.danchenski.SensorDataHandler.models.MeasurementDTO;
import ru.danchenski.SensorDataHandler.models.SensorDTO;
import ru.danchenski.SensorDataHandler.repositories.SensorRepository;
import ru.danchenski.SensorDataHandler.utils.ErrorsUtil;
import ru.danchenski.SensorDataHandler.utils.MeasurementErrorResponse;
import ru.danchenski.SensorDataHandler.validators.SensorValidator;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorMapper sensorMapper;
    private final SensorRepository sensorRepository;
    private final SensorValidator sensorValidator;

    public Optional<SensorEntity> findByName(String name) {
        return sensorRepository.findByName(name);
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementException e) {
        MeasurementErrorResponse response = new MeasurementErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<HttpStatus> register(SensorDTO sensorDTO, BindingResult bindingResult) {

        SensorEntity sensorEntity = sensorMapper.toSensorEntity(sensorDTO);
        sensorValidator.validate(sensorEntity, bindingResult);

        if (bindingResult.hasErrors())
            ErrorsUtil.returnErrorsToClient(bindingResult);

        sensorRepository.save(sensorEntity);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
