package kremelv.RestSensorApp.controllers;

import jakarta.validation.Valid;
import kremelv.RestSensorApp.dto.MeasurementDTO;
import kremelv.RestSensorApp.models.Measurement;
import kremelv.RestSensorApp.services.MeasurementService;
import kremelv.RestSensorApp.util.Convertor;
import kremelv.RestSensorApp.util.ErrorUtil;
import kremelv.RestSensorApp.util.MeasurementError;
import kremelv.RestSensorApp.util.MeasurementValidator;
import kremelv.RestSensorApp.util.MeasurementsResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;

    private final MeasurementValidator measurementValidator;

    public MeasurementController(MeasurementService measurementService, MeasurementValidator measurementValidator) {
        this.measurementService = measurementService;
        this.measurementValidator = measurementValidator;

    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO, BindingResult bindingResult) {
        measurementValidator.validate(Convertor.convert(measurementDTO, Measurement.class), bindingResult);
        if (bindingResult.hasErrors()) {
            throw new MeasurementError(ErrorUtil.sendErrorToClient(bindingResult));
        }
        measurementService.save(Convertor.convert(measurementDTO, Measurement.class));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public MeasurementsResponse getAllMeasurements() {
        MeasurementsResponse measurementsResponse = new MeasurementsResponse();
        measurementsResponse.setMeasurementList(measurementService.findAll().stream().map(x -> Convertor.convert(x, MeasurementDTO.class)).collect(Collectors.toList()));
        return measurementsResponse;
    }

    @GetMapping("/rainyDaysCount")
    public long RainyDaysCount() {
        return measurementService.findAll().stream().filter(x -> x.isRaining()).count();
    }


}
