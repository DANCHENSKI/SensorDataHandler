package ru.danchenski.SensorDataHandler.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.danchenski.SensorDataHandler.models.MeasurementDTO;

import java.util.List;

@Data
@AllArgsConstructor
public class MeasurementsResponse {
    private List<MeasurementDTO> measurements;
}
