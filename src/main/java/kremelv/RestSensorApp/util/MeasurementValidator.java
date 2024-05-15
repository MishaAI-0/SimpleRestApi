package kremelv.RestSensorApp.util;

import kremelv.RestSensorApp.models.Measurement;
import kremelv.RestSensorApp.services.SensorService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class MeasurementValidator implements Validator {

    private final SensorService sensorService;

    public MeasurementValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurement.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurement measurement = (Measurement) target;

        if (measurement.getSensor() == null) {
            return;
        }

        if (!sensorService.findByName(measurement.getSensor().getName()).isPresent()) {
            errors.rejectValue("sensor","","This sensor does not exist");
        }
    }
}
