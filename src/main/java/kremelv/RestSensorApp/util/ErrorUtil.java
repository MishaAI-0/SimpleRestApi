package kremelv.RestSensorApp.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

public class ErrorUtil {

    public static String sendErrorToClient(BindingResult bindingResult) {
        List<String> errorMessages = bindingResult.getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        return String.join(", ", errorMessages);
    }
}
