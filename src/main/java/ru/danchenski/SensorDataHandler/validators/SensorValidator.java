package ru.danchenski.SensorDataHandler.validators;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.danchenski.SensorDataHandler.entities.SensorEntity;
import ru.danchenski.SensorDataHandler.repositories.SensorRepository;
import ru.danchenski.SensorDataHandler.services.SensorService;

@Component
@RequiredArgsConstructor

public class SensorValidator implements Validator {

    private final SensorRepository sensorRepository;


    @Override
    public boolean supports(Class<?> clazz) {
        return SensorEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SensorEntity sensorEntity = (SensorEntity) target;

        if (sensorRepository.findByName(sensorEntity.getName()).isPresent())
            errors.rejectValue("name", "Уже есть сенсор с таким именем!");
    }
}
