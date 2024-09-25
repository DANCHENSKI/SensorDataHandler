package ru.danchenski.SensorDataHandler.services;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.ILoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import ru.danchenski.SensorDataHandler.entities.MeasurementEntity;
import ru.danchenski.SensorDataHandler.exceptions.MeasurementException;
import ru.danchenski.SensorDataHandler.mappers.MeasurementMapper;
import ru.danchenski.SensorDataHandler.models.MeasurementDTO;
import ru.danchenski.SensorDataHandler.repositories.MeasurementRepository;
import ru.danchenski.SensorDataHandler.repositories.SensorRepository;
import ru.danchenski.SensorDataHandler.utils.ErrorsUtil;
import ru.danchenski.SensorDataHandler.utils.MeasurementErrorResponse;
import ru.danchenski.SensorDataHandler.utils.MeasurementsResponse;
import ru.danchenski.SensorDataHandler.validators.MeasurementValidator;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeasurementService {

    private final MeasurementMapper measurementMapper;
    private final MeasurementValidator measurementValidator;
    private final MeasurementRepository measurementRepository;
    private final SensorService sensorService;

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementException e) {
        MeasurementErrorResponse response = new MeasurementErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<HttpStatus> add(@RequestBody @Valid MeasurementDTO measurementDTO,
                                          BindingResult bindingResult) {
        MeasurementEntity measurementEntity = measurementMapper.toMeasurementEntity(measurementDTO);
        measurementValidator.validate(measurementEntity, bindingResult);
        if (bindingResult.hasErrors())
            ErrorsUtil.returnErrorsToClient(bindingResult);


        enrichMeasurement(measurementEntity);
        measurementRepository.save(measurementEntity);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    public MeasurementsResponse getMeasurements() {
        return new MeasurementsResponse(measurementRepository.findAll().stream().map(this::convertToMeasurementDTO)
                .collect(Collectors.toList()));
    }

    private MeasurementDTO convertToMeasurementDTO(MeasurementEntity measurementEntity) {
        return measurementMapper.toMeasurementDTO(measurementEntity);
    }

    private void enrichMeasurement(MeasurementEntity measurementEntity) {
        measurementEntity.setSensor(sensorService.findByName(measurementEntity.getSensor().getName()).get());

        measurementEntity.setMeasurementDateTime(LocalDateTime.now());
    }

    public Long getRainyDaysCount() {
        return measurementRepository.findAll().stream().filter(MeasurementEntity::getRaining).count();
    }
}
