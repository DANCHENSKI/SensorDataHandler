package ru.danchenski.SensorDataHandler.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.danchenski.SensorDataHandler.models.SensorDTO;
import ru.danchenski.SensorDataHandler.services.SensorService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO
    , BindingResult bindingResult) {
        return sensorService.register(sensorDTO, bindingResult);
    }
}
