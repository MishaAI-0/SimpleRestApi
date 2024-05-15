package kremelv.RestSensorApp.controllers;

import jakarta.validation.Valid;
import kremelv.RestSensorApp.dto.SensorDTO;
import kremelv.RestSensorApp.models.Sensor;
import kremelv.RestSensorApp.services.SensorService;
import kremelv.RestSensorApp.util.Convertor;
import kremelv.RestSensorApp.util.ErrorUtil;
import kremelv.RestSensorApp.util.SensorException;
import kremelv.RestSensorApp.util.SensorValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;
    private final SensorValidator sensorValidator;

    public SensorController(SensorService sensorService, SensorValidator sensorValidator) {
        this.sensorService = sensorService;
        this.sensorValidator = sensorValidator;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registerSensor(@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult) {
        sensorValidator.validate(Convertor.convert(sensorDTO, Sensor.class), bindingResult);
        if (bindingResult.hasErrors()) {
            throw new SensorException(ErrorUtil.sendErrorToClient(bindingResult));
        }
        sensorService.saveSensor(Convertor.convert(sensorDTO, Sensor.class));
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
