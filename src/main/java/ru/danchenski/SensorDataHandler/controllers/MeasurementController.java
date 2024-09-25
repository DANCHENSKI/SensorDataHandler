package ru.danchenski.SensorDataHandler.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.danchenski.SensorDataHandler.models.MeasurementDTO;
import ru.danchenski.SensorDataHandler.services.MeasurementService;
import ru.danchenski.SensorDataHandler.utils.MeasurementsResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid MeasurementDTO measurementDTO,
                                          BindingResult bindingResult) {
        return measurementService.add(measurementDTO, bindingResult);
    }

    @GetMapping
    public MeasurementsResponse getMeasurements() {
        return measurementService.getMeasurements();
    }

    @GetMapping("/rainyDaysCount")
    public Long getRainyDaysCount() {
        return measurementService.getRainyDaysCount();
    }
}
