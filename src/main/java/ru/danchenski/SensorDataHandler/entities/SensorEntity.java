package ru.danchenski.SensorDataHandler.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "sensor", schema = "sensor_data_db")
public class SensorEntity implements Serializable { // В качестве ключа не используем id в Measurement

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "Название не должно быть пустым!")
    @Size(min = 3, max = 30, message = "Название сенсора должно быть от 3 до 30 символов!")
    private String name;
}
