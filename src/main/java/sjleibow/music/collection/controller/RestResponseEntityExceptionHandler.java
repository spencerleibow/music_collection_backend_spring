package sjleibow.music.collection.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import sjleibow.music.collection.exception.ApiError;
import sjleibow.music.collection.exception.ApiException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {
	
	private static final Logger logger = LogManager.getLogger(RestResponseEntityExceptionHandler.class);
	
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiError> handleThrowable(ApiException e) {
		ApiError apiError = new ApiError(e);
		logger.info(String.format("API ERROR: %s", apiError.getMessage()));
		return new ResponseEntity<ApiError>(apiError, apiError.getHttpStatus());
    }
	
    @ExceptionHandler(value = Throwable.class)
    public ResponseEntity<ApiError> handleThrowable(Throwable e) {
		ApiError apiError = new ApiError(e);
		logger.error(e.getMessage());
		e.printStackTrace();
		return new ResponseEntity<ApiError>(apiError, apiError.getHttpStatus());
    }
}
