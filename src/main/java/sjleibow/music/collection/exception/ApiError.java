package sjleibow.music.collection.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ApiError {
	
	private HttpStatus httpStatus;
	private LocalDateTime timestamp;
	private String message;	
	
	public ApiError(ApiException e) {
		httpStatus = e.getClass().getAnnotationsByType(ResponseStatus.class)[0].value();
		timestamp = LocalDateTime.now();
		message = e.getMessage();
	}

	public ApiError(Throwable e) {
		httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		timestamp = LocalDateTime.now();
		message = e.getMessage();
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public int getHttpStatusCode() {
		return httpStatus.value();
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}
}
