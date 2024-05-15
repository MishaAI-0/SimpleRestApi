package kremelv.RestSensorApp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "measurement")
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private int id;

    @Column(name = "temperature")
    @NotNull(message = "temperature can not be empty")
    @Min(value = -100, message = "Min value = -100")
    @Max(value = 100, message = "Max value = 100")
    private Double temperature;

    @Column(name = "raining")
    @NotNull(message = "Raining can not be empty")
    private Boolean raining;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    @NotNull(message = "Sensor can not be empty")
    private Sensor sensor;

    public Measurement() {
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
