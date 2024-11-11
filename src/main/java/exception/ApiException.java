package exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {
    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime timeStamps;

    public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timeStamps) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timeStamps = timeStamps;
    }
}
