package kremelv.RestSensorApp.util;

import java.time.LocalDateTime;

public class MeasurementErrorResponse {
    private String message;
    private LocalDateTime  time;

    public MeasurementErrorResponse() {
    }

    public MeasurementErrorResponse(String message, LocalDateTime time) {
        this.message = message;
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
