package kremelv.RestSensorApp.util;

import kremelv.RestSensorApp.models.Sensor;
import kremelv.RestSensorApp.services.SensorService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SensorValidator  implements Validator {
    private final SensorService sensorService;

    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;
        if (sensorService.findByName(sensor.getName()).isPresent()) {
            errors.rejectValue("name","","This name is already taken");
        }
    }
}
