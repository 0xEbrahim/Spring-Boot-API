package exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.Date;

public class ApiExceptionResponse {
    private final String message;
    private final HttpStatus httpStatus;
    private final Date timeStamps;

    public ApiExceptionResponse(String message, HttpStatus httpStatus, Date timeStamps) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timeStamps = timeStamps;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Date getTimeStamps() {
        return timeStamps;
    }
}
