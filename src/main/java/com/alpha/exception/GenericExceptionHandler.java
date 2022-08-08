package com.alpha.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.alpha.dto.Status;
import com.alpha.response.GenericResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, 
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.info("GlobalExceptionHandler -> handleMethodArgumentNotValid method call");
		Map<String, String> errors = new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach((error) ->{	
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		GenericResponse body=new GenericResponse();
		body.setStatus(Status.FAILURE);
		body.setError(errors);;
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleOtherException(Exception exception, WebRequest request) {
		log.info("GlobalExceptionHandler -> handleException method call");
		log.error("Exception : ", exception);
		GenericResponse body=new GenericResponse();
		body.setStatus(Status.FAILURE);
		body.setError(exception.getMessage());
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AlphaApiException.class)
	public ResponseEntity<Object> handleDException(AlphaApiException exception, WebRequest request) {
		log.info("GenericExceptionHandler -> handleAlphaApiException method call");
		GenericResponse body=new GenericResponse();
		body.setStatus(Status.FAILURE);
		body.setError(exception.getAlphaApiMessage());
		return new ResponseEntity<Object>(body, new HttpHeaders(), HttpStatus.PRECONDITION_FAILED);
	}
}

