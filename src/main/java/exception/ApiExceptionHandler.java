package exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ApiExceptionResponse> handleApplicationException(ApplicationException exc){
        String message = exc.getMessage();
        HttpStatus status = exc.getStatus();
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                message,
                status,
               new Date());
        return new ResponseEntity<>(apiExceptionResponse, status);
    }
}
