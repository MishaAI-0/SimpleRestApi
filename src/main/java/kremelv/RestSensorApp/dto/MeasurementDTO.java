package kremelv.RestSensorApp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MeasurementDTO {


    @NotNull(message = "temperature can not be empty")
    @Min(value = -100, message = "Min value of temperature = -100")
    @Max(value = 100, message = "Max value of temperature = 100")
    private Double temperature;

    @NotNull(message = "raining can not be empty")
    private Boolean raining;

    @NotNull(message = "Sensor can not be empty")
    private SensorDTO sensor;

    public MeasurementDTO() {
    }


    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }


    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
