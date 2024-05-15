package kremelv.RestSensorApp.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SensorException.class)
    private ResponseEntity<SensorErrorResponse> handleExistNameException(SensorException e) {
        SensorErrorResponse response = new SensorErrorResponse(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    private ResponseEntity<SensorErrorResponse> handleValidNameException(ConstraintViolationException e) {
        SensorErrorResponse response = new SensorErrorResponse(e.getConstraintViolations().stream().map(ConstraintViolation::getMessageTemplate).collect(Collectors.joining(", ")),
                LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MeasurementError.class)
    private ResponseEntity<MeasurementErrorResponse> handleExistSensorException(MeasurementError e) {
        MeasurementErrorResponse response = new MeasurementErrorResponse(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
}
