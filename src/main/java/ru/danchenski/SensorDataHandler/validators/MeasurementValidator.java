package ru.danchenski.SensorDataHandler.validators;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.danchenski.SensorDataHandler.entities.MeasurementEntity;
import ru.danchenski.SensorDataHandler.repositories.SensorRepository;
import ru.danchenski.SensorDataHandler.services.SensorService;

@Component
@RequiredArgsConstructor
public class MeasurementValidator implements Validator {

    private final SensorRepository sensorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return MeasurementEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MeasurementEntity measurementEntity = (MeasurementEntity) target;

        if (measurementEntity.getSensor() == null) {
            return;
        }

        if (sensorRepository.findByName(measurementEntity.getSensor().getName()).isEmpty())
            errors.rejectValue("sensor", "Нет зарегистрированного сенсора с таким именем!");

    }
}
