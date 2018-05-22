package sjleibow.music.collection.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class ApiException extends RuntimeException {
	
	private HttpStatus httpStatus;

	public ApiException(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
