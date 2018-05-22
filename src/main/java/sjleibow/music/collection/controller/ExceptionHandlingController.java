package sjleibow.music.collection.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import sjleibow.music.collection.exception.ApiException;

@ControllerAdvice
public class ExceptionHandlingController {
	
	@ExceptionHandler(value = Exception.class)
	void handleExcpetion(HttpServletResponse response, Exception e) throws IOException {
		response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	void handleMissingParams(HttpServletResponse response, MissingServletRequestParameterException e) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

	@ExceptionHandler(value = ApiException.class)
	void handleApiExcpetion(HttpServletResponse response, ApiException e) throws IOException {
		response.sendError(e.getHttpStatus().value(), e.getMessage());
	}
}
