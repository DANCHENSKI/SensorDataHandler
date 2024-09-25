package ru.danchenski.SensorDataHandler.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Measurement", schema = "sensor_data_db")
public class MeasurementEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value")
    @NotNull
    @Min(-100)
    @Max(+100)
    private Double value;

    @Column(name = "raining")
    @NotNull
    private Boolean raining;

    @NotNull
    @Column(name = "measurement_date_time")
    private LocalDateTime measurementDateTime;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    private SensorEntity sensor ;

}
