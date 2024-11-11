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
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(exc.getMessage(), HttpStatus.BAD_REQUEST, Date.from(Instant.now(Clock.systemUTC())));
        return new ResponseEntity<>(apiExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
