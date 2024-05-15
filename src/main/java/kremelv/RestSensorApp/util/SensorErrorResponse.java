package kremelv.RestSensorApp.util;

import java.time.LocalDateTime;

public class SensorErrorResponse {

    private String message;
    private LocalDateTime time;

    public SensorErrorResponse(String message, LocalDateTime time) {
        this.time = time;
        this.message = message;
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
